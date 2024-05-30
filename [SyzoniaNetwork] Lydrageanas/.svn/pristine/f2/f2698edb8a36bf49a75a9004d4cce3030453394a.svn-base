package fr.syzonia.lydrageanas.servers;

public class ScannerRunnable implements Runnable{

	private ServerScanner scanner;
	
	@Override
	public void run() {
		if(scanner == null) scanner = new ServerScanner();
		scanner.check();
	}
	
}
