package cn.课堂学习.面向对象;

/*
 * 1.打电话，收发短信
 * 2.有照相、摄像、蓝牙（无线文件传输）
 *
 * 描述功能：继承了手机功能（打电话、收发短信），实现了照相、摄像、蓝牙等功能.
 *  class Telephone 
 *  interface camera ,video bluetooth 
 * */
abstract class Telephone {
	// 打电话
	public abstract void callUp();

	// 发短信
	public abstract void sendMessage();

}

interface ICamera {
	// 照相功能
	public abstract void takePhoto();
}

interface IVideo {
	// 摄像功能
	public abstract void pickUp();

}

interface IBlueTooth {
	// 无线传输功能
	public abstract void wirelessTransmission();
}

public class Oppo extends Telephone implements ICamera, IVideo, IBlueTooth {

	@Override
	public void callUp() {
		System.out.println("打电话。");
	}

	@Override
	public void sendMessage() {
		System.out.println("发短信。");
	}

	@Override
	public void wirelessTransmission() {
		System.out.println("无线传输。");

	}

	@Override
	public void pickUp() {
		System.out.println("摄像。");

	}

	@Override
	public void takePhoto() {
		System.out.println("拍照。");
	}

	public void showfunction(Telephone telephone, ICamera camera, IVideo video, IBlueTooth blueTooth) {
		telephone.callUp();
		telephone.sendMessage();
		camera.takePhoto();
		video.pickUp();
		blueTooth.wirelessTransmission();
	}
}

class Test {
	public static void main(String[] args) {
		/*
		 * Telephone oppo1=new Oppo(); oppo1.callUp(); oppo1.sendMessage(); ICamera
		 * oppo2=new Oppo(); oppo2.takePhoto(); IVideo oppo3=new Oppo(); oppo3.pickUp();
		 * IBlueTooth oppo4=new Oppo(); oppo4.wirelessTransmission();
		 */

		Oppo oppo = new Oppo();
		oppo.showfunction(oppo, oppo, oppo, oppo);
	}
}
