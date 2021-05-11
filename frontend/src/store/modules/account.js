import axios from '@/api'

// 세션에 저장되어 있는 사용자 정보를 가지고 온다.
// 없다면 uid를 비워둔다.

const state = {
	uid: '',
	username: '',
	isAuth: false,
};

const getters = {
	getUid(state) {
		return state.uid;
	},
	getUsername(state) {
		return state.username;
	},
	isAuth(state) {
		return state.isAuth;
	}
}

const mutations = {
	setUserInfo(state, payload) {
		state.uid = payload.id;
		state.username = payload.username;
		state.isAuth = true;
		
	}
}

const actions = {
	submitLoginForm(context, {username, password}) {
		axios.post("/login", {username, password})
			.then(function(response) {
				context.commit('setUserInfo', response.data);
				// 세션에 사용자 정보 저장하기
			})
			.catch(function(error) {
				console.log(error);
			}); 
	},	
}

export default {
	state,
	getters,
	mutations,
	actions,
}