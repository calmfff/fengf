const mutations = {
  CHANGE_LOADING: (state, loadingFlag) => {
    state.loadingFlag = loadingFlag;
    sessionStorage.setItem("loadingFlag", loadingFlag);
  },
  CHANGE_LOADING_HEIGHT: (state, loadingHeight) => {
    state.loadingHeight = loadingHeight;
    sessionStorage.setItem("loadingHeight", loadingHeight);
  },
}

export default mutations
