<template>
  <div style="padding: 20px">
    <h1 id="tittle">Product Info</h1>
    <div id="infobox">
        <div style="height:200px; padding:15px">
            <span ref="spanimg" :key="i" v-for="src,i in previews">
            <img class="selectimg" v-if="src && src.length" :src="src"/>
            </span>
            <br>
            <div ref="inputfile">
           <input ref="imageInput" type="file" accept="image/*" hidden @change="onAddFiles">
            </div>
            <button type="button" @click="onClickImageUpload">이미지 업로드</button>
        </div>
            <table>
                <tr>
                    <td>Product:</td>
                    <td><input class="inputStyle" type="text" v-model="productname"></td>
                </tr>
                <br>
                 <tr>
                    <td>Price</td>
                    <td><input class="inputStyle" type="text" v-model="price"></td>
                </tr>
                <br>
                 <tr>
                    <td>Location</td>
                    <td><input class="inputStyle" type="text" v-model="location"></td>
                </tr>
                <br>
                <tr>
                    <td>Category</td>
                    <td><input class="inputStyle" type="text" v-model="category"></td>
                </tr>
                
                <br>
           </table>
           
           <input type="text" v-model="productDescription" style="width: 275px; height: 50px">
           <br>
           <br>
          <button @click="test">등록 </button>

    </div>
  </div>
</template>

<script>
import axios from '../api'


export default {
  data() {
      return{
          productname:null,
          price:null,
          location:null,
          category:null,
          imageUrl:null,
          productDescription: null,
          previews: [],
        // filename: [],
            filename:"",
          errorImage: "url of an image to use to indicate an error"
      };
  },

  methods: {
    test(){
        axios.get('/productinfo', {
            params: {
                userId: 1,
                productName: this.productname,
                price: this.price,
                location: this.location, 
                category: this.category, 
                image: this.filename,
                productDescription: this.productDescription
            },
            headers: { 'Content-Type': 'application/json' }
            }).then(function(response) {
            console.log(response.data);
            })
            .catch(function(error) {
            console.log(error);
            })
        },
        onClickImageUpload() {
            this.$refs.imageInput.click();
        },
        onAddFiles(e) {
            this.previews = [];
            this.filename = [];
            // console.log(this.$refs.imageInput.files.length)
            // if (e.target.files.length>2) {
            //     alert("이미지는 2개 이하입니다.")
            // }
            e.target.files.forEach((file, index) => {
            this.previews[index] = URL.createObjectURL(file);
            this.filename = file.name
            console.log(file)
            });
        }   
  }
}
</script>

<style>
*{
    box-sizing: border-box;
}
h1{
    text-align: center;
    font-size: 25px;
}
#infobox{
    /* border: 1px solid; */
    text-align: -webkit-center;
    /* padding: 25px; */
}
.inputStyle {
    width: 200px;
    margin-left: 5px;
}

td {
    text-align-last: center;
}
#app>img{
    width: 50px;
}
#app{
    text-align: center;
}
.selectimg{
    height: -webkit-fill-available;
    padding: 5px;
}
button{
    border:1px solid black;
    padding-left: 20px; 
    padding-right: 20px;
    margin-top: 5px;
    background-color: rgb(238, 238, 238)
}
table{
    margin-top:20px;
}
</style>