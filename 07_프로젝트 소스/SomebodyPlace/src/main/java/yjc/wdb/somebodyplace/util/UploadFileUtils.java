package yjc.wdb.somebodyplace.util;

import java.awt.image.*;
import java.io.*;
import java.text.*;
import java.util.*;

import javax.imageio.*;

import org.imgscalr.*;
import org.springframework.util.*;

public class UploadFileUtils {
	
	public static String uploadFile(String originalName, String uploadPath, byte[] fileData) throws Exception {
	
		/*		originalName : rose.jpg
		 * 		==>
		 * 
		 * 		rose_asdfjlfjdi3ruoiew.jpg
		 * */
		
		UUID uid = UUID.randomUUID();
		int extIndx = originalName.lastIndexOf(".");
		String nameWithoutExtension = originalName.substring(0, extIndx);
		String savedName = nameWithoutExtension+"_"+uid.toString();
		savedName += originalName.substring(extIndx);
		
		String savedPath = calculatePath(uploadPath);
		
		File target = new File(uploadPath+savedPath, savedName);
		System.out.println(target.getAbsolutePath());
		FileCopyUtils.copy(fileData, target);
		
		// �̹��� �����̸� thumbnail ����
		// �ƴϸ� icon ����.
			
		String thumbNailName = "";
		String fileExtension = originalName.substring(extIndx+1);
		if(MediaUtils.getMediaType(fileExtension.toLowerCase()) != null) {
			thumbNailName = makeThumbNail(uploadPath, savedPath, savedName);
		} else {
			thumbNailName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		
		return thumbNailName;
	}
	
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {
		String iconName=uploadPath + path + File.separator+fileName;
		//resource/upload/2017/05/16/rose_adfafadsfadf.jpg
		// /2017/06/16/rose.jpg ��ȯ
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	private static String makeThumbNail(String uploadPath, String path, String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath+path, fileName));
		
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		String thumbNailName = uploadPath+path+File.separator + "thumbNail_chatting_"+fileName;
		
		File newFile = new File(thumbNailName);
		
		String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg,  fileExtension.toLowerCase(), newFile);
		thumbNailName = thumbNailName.substring(uploadPath.length());
		thumbNailName = thumbNailName.replace(File.separatorChar, '/');
		return thumbNailName;
	}
	
	private static int lastIndexOf(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static String calculatePath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		DecimalFormat df = new DecimalFormat("00");
		String monthPath = df.format(cal.get(Calendar.MONTH)+1);
		/*/2017/05 */
		monthPath = yearPath + File.separator + monthPath;
		
		/*/2017/05/12 */
		
		String datePath = File.separator+ df.format(cal.get(Calendar.DATE));
		datePath = monthPath+datePath;
		
		File folder = new File(uploadPath+datePath);
		if(folder.exists()==false) {
			folder.mkdirs();
		}
		
		return datePath;
	}
}
