package com.myexperiments.ward;

import java.io.File;
import java.net.URL;
import com.github.axet.vget.VGet;
import com.github.axet.vget.info.VideoFileInfo;
import com.github.axet.vget.info.VideoInfo;
import com.github.axet.vget.vhs.YouTubeInfo.StreamCombined;
import com.github.axet.vget.vhs.YouTubeInfo.YoutubeQuality;
import com.github.axet.wget.info.ex.DownloadError;
import com.github.axet.wget.info.ex.DownloadRetry;

public class DirectDownload {

	public static void main(String[] args) {
		try {
			// ex: http://www.youtube.com/watch?v=Nj6PFaDmp6c
//			String url = args[0];
			String url = "https://www.youtube.com/watch?v=_yzDjsdwtc8";
			// ex: "/Users/axet/Downloads"
//			String path = args[1];
			String path = "H:/DownloadVideo";

			VGet v = new VGet(new URL(url), new File(path));
			v.download();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}