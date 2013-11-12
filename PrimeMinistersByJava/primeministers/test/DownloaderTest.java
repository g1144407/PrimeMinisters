package test;

import static org.junit.Assert.*;

import org.junit.Test;

import primeministers.Downloader;

public class DownloaderTest {

	@Test
	public void test() {
		primeministers.Downloader downloader = new Downloader();
		downloader.downloadCSV();
		downloader.downloadImages();
		downloader.downloadThumbnails();
		primeministers.Table aTable = downloader.table();
		assertNotNull(aTable);	
	}
}
