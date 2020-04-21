const auth = {

  state: {
    access_token: sessionStorage.getItem('access_token'),
    refresh_token: sessionStorage.getItem('refresh_token'),
  },

  mutations: {//同步处理
    SET_ACCESS_TOKEN: (state, access_token) => {
      state.access_token = access_token;
      sessionStorage.setItem("access_token", access_token);
    },
    SET_REFRESH_TOKEN: (state, refresh_token) => {
      state.refresh_token = refresh_token;
      sessionStorage.setItem("refresh_token", refresh_token);
    },
    REMOVE_ACCESS_TOKEN: (state) => {
      state.access_token = undefined;
      sessionStorage.removeItem("access_token");
    },
    REMOVE_REFRESH_TOKEN: (state) => {
      state.refresh_token = undefined;
      sessionStorage.removeItem("refresh_token");
    },
  },

  actions: {//异步处理
    SET_TOKEN: ({commit}, {access_token, refresh_token}) => {
      commit('SET_ACCESS_TOKEN', access_token);
      commit('SET_REFRESH_TOKEN', refresh_token);
    },

    REMOVE_TOKEN: ({commit}) => {
      commit('REMOVE_ACCESS_TOKEN');
      commit('REMOVE_REFRESH_TOKEN');
    }
  }
}

export default auth
