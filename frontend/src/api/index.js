import axios from "axios";

const instance = axios.create({
	baseURL: "/fleamarket",
	headers: {
			"Content-type": "application/json",
	}
});

instance.get('/')
  .then(function(response) {
      instance.defaults.headers['X-CSRF-TOKEN'] = response.data;
  });

export default instance;
