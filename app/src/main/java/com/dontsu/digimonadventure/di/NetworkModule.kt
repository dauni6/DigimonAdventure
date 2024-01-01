package com.dontsu.digimonadventure.di

import com.dontsu.data.network.DigimonApi
import com.dontsu.data.network.DigimonInterceptor
import com.dontsu.data.network.retrofit.ResponseCallAdapterFactory
import com.dontsu.data.network.util.Url.DIGIMON_BASE_URL
import com.dontsu.presentation.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        json: Json
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DIGIMON_BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .addCallAdapterFactory(ResponseCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpclient(interceptor: DigimonInterceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideDigimonLoggingInterceptor(): DigimonInterceptor = DigimonInterceptor()

    @Provides
    @Singleton
    fun provideDigimonApi(retrofit: Retrofit): DigimonApi {
        return retrofit.create(DigimonApi::class.java)
    }

    /**
     * Json 파싱시 발생할 수 있는 문제에 대한 객체속성을 정의합니다.
     * ```
     * 1) isLenient : JSON 직렬화 및 역직렬화 시에 엄격한(strict) 모드 여부를 제어합니다.
     * true로 설정하면 역직렬화 중에 발견된 잘못된 JSON 형식에 대해 더 유연하게 처리합니다.
     *
     * 2) ignoreUnknownKeys : Response 객체에 없는 Key를 받을 때 발생하는 JsonDecodingException 에러를 방지하기 위해 true로 설정합니다.
     * // Json
     * {
     *   "idx": "8", // idx가 있음
     *   "question": "Q. 카드결제 했는데 자동반영 또는 쿠폰발행이 안 됩니다.",
     *   "answer": "카드결제 시 카드 대행사쪽에서..."
     * }
     *
     * data class FaqContentResponse(
     *    // FQ_idx에 대한 프로퍼티가 없음! ignoreUnknownKeys = true 하지않으면 에러 발생!
     *    @SerialName("question")
     *    val question: String? = null,
     *    @SerialName("answer")
     *    val answer: String? = null
     * )
     *
     * 3) coerceInputValues : JSON 직렬화 및 역직렬화 중에 입력 값을 자동으로 변환(coerce)할지 여부를 제어합니다.
     * true로 설정하면, JSON 데이터가 예상한 형식과 일치하지 않는 경우 자동으로 변환을 시도하여 예상 형식으로 맞추려고 합니다. 예를 들어,
     * {
     *  "name": "홍길동"
     *  "age": "25"
     * }
     *
     * data class User(
     *  val name: String,
     *  val age: Int
     * )
     *
     * Json으로 문자열로 age를 받았지만 User 데이터 클래스에는 age가 Int형이므로 자동으로 Int로 형변환되어 Person 객체로 만들어줍니다.
     *
     *  4) encodeDefaults : 직렬화 시에 클래스의 기본값을 포함하도록 합니다.
     * data class User(
     *  val name: String = "홍길동",
     *  val age: Int
     * )
     *
     *  서버로 User(age = 25)로 보내면
     *  {
     *      "name":"홍길동",
     *      "age":25
     *  }
     *  기본값 "홍길동"이 보내지게 됩니다.
     * ```
     * */
    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            isLenient = true
            ignoreUnknownKeys = true
            coerceInputValues = true
            encodeDefaults = true
        }
    }

}
