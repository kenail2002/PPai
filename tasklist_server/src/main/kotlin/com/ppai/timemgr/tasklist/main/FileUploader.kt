package com.ppai.timemgr.tasklist.main


import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest
import java.io.File
import java.io.IOException
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import javax.servlet.http.HttpServletRequest
import java.nio.file.attribute.PosixFilePermissions
import java.nio.file.attribute.PosixFilePermission
import java.nio.file.attribute.FileAttribute



@Controller
class FileUploadController {

    /*
     * 获取file.html页面
     */
    @GetMapping("/file")
    fun file(): String {
        return "/filemngr/file.html"
    }

    /**
     * 实现文件上传
     */
    @PostMapping("/filemgr/fileUpload")
    @ResponseBody
    fun fileUpload(@RequestParam("fileName") file: MultipartFile): String {
        if (file.isEmpty) {
            return "false"
        }
        val fileName = file.originalFilename
        val size = file.size.toInt()
        println("$fileName-->$size")

        val path = UUID.randomUUID().toString()

        val p = Paths.get("d:\\test\\$path","$fileName");
        val dest = Files.createDirectories(p.parent)
        println("dest path=" + dest)
        println("abs path=" + p)
        try {
            file.transferTo(p) //保存文件
            return "true"
        } catch (e: IllegalStateException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            return "false"
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            return "false"
        }

    }

    /*
     * 获取multifile.html页面
     */

    @GetMapping("/multifile")
    fun multifile(): String {
        return "/filemgr//multifile.html"
    }

    /**
     * 实现多文件上传
     */
    @PostMapping("/filemgr/multifileUpload")
    @ResponseBody
            /**
             * public @ResponseBody String multifileUpload(@RequestParam("fileName")List<MultipartFile> files)
            </MultipartFile> */
    fun multifileUpload(request: HttpServletRequest): String {

        val files = (request as MultipartHttpServletRequest).getFiles("fileName")

        if (files.isEmpty()) {
            return "false"
        }

        val path = UUID.randomUUID().toString()


        for (file in files) {
            val fileName = file.originalFilename
            val size = file.size.toInt()
            println("$fileName-->$size")

            if (file.isEmpty) {
                return "false"
            } else {
                val p = Paths.get("d:\\test\\$path","$fileName");

                val dest = Files.createDirectories(p.parent)
                println("dest path=" + dest)
                println("abs path=" + p)
                try {
                    file.transferTo(p)
                } catch (e: Exception) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                    return "false"
                }

            }
        }
        return "true"
    }
}