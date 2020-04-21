const getters = {
  access_token:state=>state.auth.access_token,
  refresh_token:state=>state.auth.refresh_token,
  loadingFlag:state=>state.loadingFlag,
  loadingHeight:state=>state.loadingHeight,
}

export default getters
