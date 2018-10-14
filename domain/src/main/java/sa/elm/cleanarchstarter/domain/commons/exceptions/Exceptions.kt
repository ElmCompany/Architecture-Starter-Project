package sa.elm.cleanarchstarter.domain.commons.exceptions


open class BaseException(errorMessage: String? = null, exception: Throwable? = null)
    : Exception(errorMessage, exception)

class ApiException(errorMessage: String) : BaseException()
class UnexpectedResponseException(msgId: Int) : BaseException()


