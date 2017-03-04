package com.zjsu.guanwei.picture.common;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class ImageSmaller{
	 public static void main(String[] args) throws IOException {  
		 File fromPic=new File("E:\\leslie\\5.jpg");  
	        File toPic=new File("E:\\leslie\\5samll.jpg");  
	    
	Thumbnails.of(fromPic).scale(0.5f).toFile(toPic); 
	
	 }
	}