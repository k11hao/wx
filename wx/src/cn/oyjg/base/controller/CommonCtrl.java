package cn.oyjg.base.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.oyjg.base.util.RandomCode;

@Controller
public class CommonCtrl {
	
	static final String defExt= ".jpg";
	
	/**
	 * 产生数学公工
	 * @param request
	 * @param response
	 * @throws IOException 
	 
	
	@RequestMapping(value="createTexFormulaImg")
	public void createTexFormulaImg(@RequestParam String math,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		//response.setHeader("ContentType", "image/jpeg");
		
		TeXFormula fomule = new TeXFormula(math);
		 
		
		Image img=fomule.createBufferedImage(math, fomule.BOLD, Integer.parseInt(request.getParameter("size")), Color.black, Color.white);
		 BufferedImage bi = (BufferedImage) img;
		 
		 OutputStream os=null;
		 try {
			os=response.getOutputStream();
			JPEGImageEncoder   encoder   =   JPEGCodec.createJPEGEncoder(os);     
		 	encoder.encode(bi);
		 	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os!=null){
				os.close();
			}
		}
	}
	
	*/
	@RequestMapping(value = "/preview")
	public String preview(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter writer=null;
		try {
//			writer=response.getWriter();
//			String path=request.getContextPath();
			
//			writer.print("<html><head>\r\n");
//			writer.print("<script type=\"text/javascript\" src=\""+path+"/rs/js/jquery-1.7.2.min.js\"></script>\r\n");
//			writer.print("<script type=\"text/javascript\" src=\""+path+"/rs/js/LaTeXMathML.js\"></script>\r\n");
//			writer.print("</head><body>");
//			writer.print(request.getParameter("content"));
////			writer.print("</body></html>");
			request.setAttribute("content", request.getParameter("content"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(writer!=null){
				writer.close();
			}
		}
		return "formulaPreview";
	}
	
	/**
	 * 随机验证码
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/randomImg")
	public void randomImg(HttpServletRequest request,
			HttpServletResponse response) {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);
		try {
			RandomCode.getRandcode(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/fileUplaod")
	public void fileUplaod(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter writer = response.getWriter();
		String uname=request.getParameter("uname");
		response.setHeader("charset", "UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String filename = request.getParameter("filename");
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
//		User user=(User)request.getSession().getAttribute("user");
//		uploadPath+="/"+uname+"/";
		File f1 = new File(uploadPath);
		if (!f1.exists()) {
			f1.mkdirs();
		}
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List fileList = null;

		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			ex.printStackTrace();
		}
		Iterator<FileItem> it = fileList.iterator();
		// String name = "";
		// String extName = "";

		while (it.hasNext()) {
			FileItem item = it.next();
			if (!item.isFormField()) {
				File file = null;
				file = new File(uploadPath + filename + defExt);
				try {
					if(item.getSize()>90000){
						writer.write("-2");
						return;
					}else{
						item.write(file);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
		
		try {			
			writer.print(filename + defExt);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
