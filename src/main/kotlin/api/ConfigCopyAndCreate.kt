package api

import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import java.io.*

object ConfigCopyAndCreate {
   val gson = Gson()
   var port = 25599
   var host = "127.0.0.1"

   @Throws(IOException::class)
   fun copy() {
      val file = File(System.getProperty("user.dir"), ".client/config.json")
      if (!file.parentFile.exists()) {
         file.parentFile.mkdirs()
      }
      var `in`: InputStream? = null
      var out: OutputStream? = null
      try {
         `in` = javaClass.getResourceAsStream("/config.json")
         out = FileOutputStream(file)
         val buf = ByteArray(1024)
         var bytesRead: Int
         while (`in`.read(buf).also { bytesRead = it } > 0) {
            out.write(buf, 0, bytesRead)
         }
      } catch (e: IOException) {
         println(e.message)
      } finally {
         `in`!!.close()
         out!!.close()
      }
   }

   fun init() {
      try {
         copy()
      } catch (e: IOException) {
         println(e.message)
      }
      var linkedTreeMap = gson.fromJson(InputStreamReader(javaClass.getResourceAsStream("/config.json")!!), LinkedTreeMap::class.java)
      val get = linkedTreeMap.get("port")
      if (get is Double) {
         port = get.toInt()
      }
      val host = linkedTreeMap.get("ip")
      if (host is String?) {
         this.host = host!!
      }


   }
}