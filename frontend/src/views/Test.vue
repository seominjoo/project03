<template>
  <div>
    <UserImage class="user-image" :uid="getUid" :size="200"></UserImage>
    <div></div>
    <button @click="$refs.file.click()" class="user-image__edit-btn">
      Edit
      <input type="file" ref="file" @change="loadImage($event)" accept="image/*">
    </button>
    <ImageCropModal v-if="showModal">
      <div slot="header" class="modal__header">
        <h2>Crop your profile picture</h2>
        <span @click="closeModal">x</span>
      </div>
      <div slot="body">
        <Cropper
          :src="image.src"
          :stencil-component="$options.components.CircleStencil"
          :stencil-props="{
            aspectRatio: 1/1
          }"
          @change="change"
          class="cropper"
        ></Cropper>
      </div>
      <div slot="footer" class="modal__footer">
        <button @click="uploadImage">Upload Image</button>
      </div>
    </ImageCropModal>
  </div>
</template>

<script>
/* eslint-disable*/
import { mapGetters } from 'vuex';
import { Cropper, CircleStencil } from 'vue-advanced-cropper'
import 'vue-advanced-cropper/dist/style.css';
import UserImage from '@/components/common/UserImage.vue';
import ImageCropModal from '@/components/common/CommonModal.vue';
import axios from '@/api';

function getMimeType(file, fallback = null) {
	const byteArray = (new Uint8Array(file)).subarray(0, 4);
    let header = '';
    for (let i = 0; i < byteArray.length; i++) {
       header += byteArray[i].toString(16);
    }
	switch (header) {
        case "89504e47":
            return "image/png";
        case "47494638":
            return "image/gif";
        case "ffd8ffe0":
        case "ffd8ffe1":
        case "ffd8ffe2":
        case "ffd8ffe3":
        case "ffd8ffe8":
            return "image/jpeg";
        default:
            return fallback;
    }
}

export default {
  components: {
    Cropper,
    CircleStencil,
    UserImage,
    ImageCropModal,
  },
  data: () => {
    return {
      showModal: false,
      image: {
        src: null,
        type: null,
        file: null,
        coordinates: null,
      }
    }
  },
  computed: {
    ...mapGetters(['getUid']),
  },
  methods: {
    change({coordinates, canvas}) {
      this.image.coordinates = coordinates;
    },
    loadImage(event) {
      const { files } = event.target;

      if (files && files[0]) {
        if (this.image.src) {
          URL.revokeObjectURL(this.image.src);
        }

        const blob = URL.createObjectURL(files[0]);
        const reader = new FileReader();

        reader.onload = (e) => {
          this.image = {
            src: blob,
            type: getMimeType(e.target.result, files[0].type),
            file: files[0],
          };
        };

        reader.readAsArrayBuffer(files[0]);
      }

      this.showModal = true;
    },
    uploadImage() {
      console.log(this.image.coordinates);

      const form = new FormData();
      form.append('file', this.image.file);
      form.append('x', this.image.coordinates.left);
      form.append('y', this.image.coordinates.top);
      form.append('width', this.image.coordinates.width);
      form.append('height', this.image.coordinates.height);

      axios.post('/account/image', form, {
        header: {
          'Content-Type': 'multipart/form-data'
        }
      })
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        console.log(error);
      });

      this.closeModal();
    },
    closeModal() {
      this.showModal = false;
      this.reset();
      this.destroy();
    },
    reset() {
      this.image = {
        src: null,
        type: null,
        file: null,
        coordinates: null,
      }
    },
    destroy() {
      if (this.image.src) {
        URL.revokeObjectURL(this.image.src);
      }
    },
  }
}
</script>

<style scoped>
.user-image {
  border-radius: 0;
}
.user-image__edit-btn input {
  display: none;
}

.cropper {
  background: #DDD;
}
.modal__header {
  display: flex;
  justify-content: space-between;
  font-size: 20px;
  font-weight: 500;
  margin-bottom: 10px;
}
.modal__header span {
  cursor: pointer;
  margin-left: 10px;
}
.modal__footer button {
  width: 100%;
  margin-top: 10px;
  padding: 6px 2px;
}
</style>