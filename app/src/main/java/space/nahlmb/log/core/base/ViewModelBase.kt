package space.nahlmb.log.core.base

interface ViewModelBase
{
    fun fetch()
    fun onSuccessFetch()
    fun onFailedFetch()
    fun turnLoading()
    fun stopLoading()
    fun turnError()
    fun stopError()
    fun turnEmpty()
    fun stopEmpty()
}