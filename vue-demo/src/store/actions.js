const actions = {
  CHANGE_LOADING: ({commit}, {loadingFlag}) => {
    commit('CHANGE_LOADING', loadingFlag);
  },
  CHANGE_LOADING_HEIGHT: ({commit}, {loadingHeight}) => {
    commit('CHANGE_LOADING_HEIGHT', loadingHeight);
  },
}

export default actions
