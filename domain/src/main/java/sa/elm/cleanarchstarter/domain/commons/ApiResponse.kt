package sa.elm.cleanarchstarter.domain.commons

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
        @field:SerializedName("code")
        val code: Int,
        @field:SerializedName("messageType")
        val messageType: String,
        @field:SerializedName("messageCode")
        val messageCode: String?,
        @field:SerializedName("value")
        val value: T?,
        @field:SerializedName("successful")
        val successful: Boolean
)