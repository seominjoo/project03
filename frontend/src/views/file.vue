
<template>
  <div class="container">
    <div class="large-12 medium-12 small-12 cell">
      <label>Files
        <input type="file" id="files" ref="files" multiple v-on:change="handleFilesUpload()"/>
      </label>
    </div>
    <div class="large-12 medium-12 small-12 cell">
      <div :key="key" v-for="(file, key) in files" class="file-listing">{{ file.name }} <span class="remove-file" v-on:click="removeFile( key )">Remove</span></div>
    </div>
    <br>
    <div class="large-12 medium-12 small-12 cell">
      <button v-on:click="addFiles()">Add Files</button>
    </div>
    <br>
    <div class="large-12 medium-12 small-12 cell">
      <button v-on:click="submitFiles()">Submit</button>
    </div>
  </div>
</template>

<script>

import axios from '../api'

  export default {
    data(){
      return {
        files: []
      }
    },
    methods: {
      addFiles(){
        this.$refs.files.click();
      },
      submitFiles(){
        let formData = new FormData();
        for( var i = 0; i < this.files.length; i++ ){
          let file = this.files[i];
          formData.append('files[' + i + ']', file);
        }
        axios.get( '/select-files',
          formData,
          {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
          }
        ).then(function(){
          console.log('SUCCESS!!');
        })
        .catch(function(){
          console.log('FAILURE!!');
        });
      },
      handleFilesUpload(){
        let uploadedFiles = this.$refs.files.files;
        for( var i = 0; i < uploadedFiles.length; i++ ){
          this.files.push( uploadedFiles[i] );
        }
      },
      removeFile( key ){
        this.files.splice( key, 1 );
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