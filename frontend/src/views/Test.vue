<template>
  <div>
		<h1>Test Page</h1>
		<MyModal v-if="showModal">
			<h1 slot="header" class="modal__header">LOREM</h1>
			<div slot="body" class="modal__body">
				Lorem ipsum dolor sit amet consectetur adipisicing elit. Quibusdam, excepturi eum reiciendis nam praesentium eligendi necessitatibus repellat perspiciatis totam recusandae corporis ea consectetur, optio expedita eos itaque laborum architecto quae?
			</div>
			<span slot="footer">
				<button v-on:click="closeModal">close</button>
			</span>
		</MyModal>
		<button v-on:click="openModal">Open</button>
  </div>
</template>

<script>
import MyModal from '@/components/common/CommonModal.vue';

export default {
	components: {
		MyModal,
	},
	data: () => {
		return {
			showModal: false,
		}
	},
	methods: {
		openModal() {
			this.showModal = true;
		},
		closeModal() {
			this.showModal = false;
		},
	}
}
</script>

<style>
.modal__header {
	font-weight: 700;
	font-size: 24px;
}
.modal__body {
	width: 500px;
}
</style>