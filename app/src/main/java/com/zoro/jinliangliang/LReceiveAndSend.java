package com.zoro.jinliangliang;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.hardware.Sensor;
import android.util.Log;

public class LReceiveAndSend {

//    private final static String TAG = "LReceiveAndSend";
//    private final static int SLEEP_TIME = 20;
//    private final static int RETRANSMISSION_TIME = 100;
//    public static DatagramSocket datagramSocket = null;
//    public static Thread receiveThread = null;
//    private static Thread sendThread = null;
//    private static Thread retransmissionThread = null;
//    private static Thread busSerialPortReadThread = null;
//    public static boolean isBack = false; // 后台标记
//
//    public static void Start() {
//
//        Stop();
//
//        try {
//
//            datagramSocket = new DatagramSocket(6000);
//            datagramSocket.setBroadcast(true);
//            datagramSocket.setReceiveBufferSize(1024 * 20);
//            datagramSocket.setReuseAddress(true);
//
//        } catch (Exception e) {
//            datagramSocket = null;
//        }
//
//        if (receiveThread == null) {
//            receiveThread = new myReceiveThread();
//            receiveThread.start();
//        }
//
//        if (sendThread == null) {
//            sendThread = new mySendThread();
//            sendThread.start();
//        }
//
//        if (retransmissionThread == null) {
//            retransmissionThread = new RetransmissionThread();
//            retransmissionThread.start();
//        }
//
//        if (busSerialPortReadThread == null) {
//            busSerialPortReadThread = new BusSerialPortReadThread();
//            busSerialPortReadThread.start();
//        }
//
//        Global.mReceiveData = data;
//    }
//
//    private static ReceiveData data = new ReceiveData() {
//
//        @Override
//        public void receiveData(int command, int desSubnetID, int desDeviceID, int subnetID, int deviceID,
//                                byte[] usefulBytes, InetAddress ip) {
//
//            // 更新发送是否成功的信息
//            SendDatas.ReceiveBytes(command, subnetID, deviceID, usefulBytes);
//
//            // 更新目标信息
//            updateDestinationInfo(command, desSubnetID, desDeviceID, subnetID, deviceID, usefulBytes, ip);
//        }
//    };
//
//    private static class myReceiveThread extends Thread {
//
//        @Override
//        public void run() {
//
//            while (true) {
//
//                try {
//
//                    byte[] receiveBytes = new byte[512];
//                    DatagramPacket dataPacket = new DatagramPacket(receiveBytes, receiveBytes.length);
//                    datagramSocket.receive(dataPacket);
//
//                    int command = Global.GetByteToInt(receiveBytes[21]) * 256 + Global.GetByteToInt(receiveBytes[22]);
//                    int subnetID = Global.GetByteToInt(receiveBytes[17]); // 源子网号
//                    int deviceID = Global.GetByteToInt(receiveBytes[18]);// 源设备号
//
//                    if (subnetID == Global.getSubnetID() && deviceID == Global.getDeviceID())
//                        continue;// 自己发送给自己的，不接收
//
//                    int desSubnetID = receiveBytes[23] & 0xFF;// 目的地址
//                    int desDeviceID = receiveBytes[24] & 0xFF;
//
//                    if (command != 58336) {
//                        if (!((desSubnetID == Global.getSubnetID() && desDeviceID == Global.getDeviceID()) || (desSubnetID == 0xff && desDeviceID == 0xff))) {
//                            continue;
//                        }
//                    }
//                    int addDataLenght = Global.GetByteToInt(receiveBytes[16]) - 11;// 有限的附加数据长度
//                    byte[] usefulBytes = new byte[addDataLenght];
//                    System.arraycopy(receiveBytes, 25, usefulBytes, 0, addDataLenght);// 复制附加数据
//
//                    if (Global.mReceiveData != null)
//                        Global.mReceiveData.receiveData(command, desSubnetID, desDeviceID, subnetID, deviceID, usefulBytes, datagramSocket.getInetAddress());
//
//                    /*
//                     * // 更新发送是否成功的信息
//                     * SendDatas.ReceiveBytes(command, subnetID, deviceID, usefulBytes);
//                     *
//                     * // 更新目标信息
//                     * updateDestinationInfo(command, subnetID, deviceID, usefulBytes, receiveBytes, dataPacket.getAddress(), datagramSocket, desSubnetID, desDeviceID);
//                     */
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    // 更新目标信息
//    private static void updateDestinationInfo(final int command, final int desSubnetID, final int desDeviceID, final int subnetID, final int deviceID, final byte[] usefulBytes, InetAddress ip) {
//
//        try {
//            // Log.e("sssss", "command=" + Integer.toHexString(command));
//            if (Commands.广播搜索.getCommand() == command) {
//                //Global.getVersionCode() + "_" + Global.getVerName();
//                String remark = "Wallapp";
//                SendDatas.AddSendData(Commands.广播搜索回复.getCommand(), subnetID, deviceID, remark.getBytes(), 3, Global.BroadcastIP, 6000);
//            } else if (Commands.ReadVersion_ACK.getCommand() == command) {
//                //
//                String version = Global.getVersionCode() + "_" + Global.getVerName();
//                SendDatas.AddSendData(Commands.广播搜索回复.getCommand(), subnetID, deviceID, version.getBytes(), 3, Global.BroadcastIP, 6000);
//            } else if (Commands.调节控制反馈.getCommand() == command) {
//                // 更新内存
//                Lamp.ControlACK(subnetID, deviceID, usefulBytes);
//                Energy.ContorlACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.调节读取反馈.getCommand() == command) {
//                Lamp.ReadACK(subnetID, deviceID, usefulBytes);
//                Energy.ReadSwitchStateACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.逻辑灯RGB控制返回.getCommand() == command || Commands.逻辑灯RGB读取反馈.getCommand() == command) {
//                Lamp.RGBControlACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.面板控制反馈.getCommand() == command) {
//                AC.Update(subnetID, deviceID, usefulBytes);
//            } else if (Commands.面板读取反馈.getCommand() == command) {// 读取面板状态反馈
//                AC.PanelACReadACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.彩屏空调总读取反馈.getCommand() == command) {
//                // AC.NewPanelACReadACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.广播温度.getCommand() == command) {
//                // AC.UpdateE3E5ACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.读取温度传感器反馈.getCommand() == command) {
//                AC.UpdateE3E8ACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.模块空调读取反馈.getCommand() == command) {
//                AC.Update(subnetID, deviceID, usefulBytes);
//            } else if (Commands.模块空调控制状态反馈.getCommand() == command) {
//                AC.Update(subnetID, deviceID, usefulBytes);
//            } else if (Commands.窗帘开关读取回复.getCommand() == command) {
//                Curtain.ReadACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.窗帘开关.getCommand() == command) {
//                int looper = usefulBytes[0] & 0xFF;
//                if (looper > 16)
//                    Curtain.ControlACK(desSubnetID, desDeviceID, usefulBytes);
//            } else if (Commands.窗帘开关回复.getCommand() == command) {
//                int looper = usefulBytes[0] & 0xFF;
//                // Curtain.ProgressControlACK(subnetID, deviceID, usefulBytes);
//                if (looper > 16) {
//                    Curtain.ProgressControlACK(subnetID, deviceID, usefulBytes);
//                } else {
//                    Curtain.ControlACK(subnetID, deviceID, usefulBytes);
//                }
//            } else if (Commands.通用开关.getCommand() == command) {
//                // 通用开关号，处理断电回复
//            } else if (Commands.能源模块值返回.getCommand() == command) {
//                if (Global.CurrentEnergy != null) {
//                    Energy.UpdateElectricValue(usefulBytes);
//                }
//            } else if (Commands.地热模块控制反馈.getCommand() == command || Commands.地热模块读取反馈.getCommand() == command) {
//                Heat.HotModeReadACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.地热面板控制反馈.getCommand() == command) {
//                Heat.HotPanelControlACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.地热面板读取反馈.getCommand() == command) {
//                Heat.HotPanelReadACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.空气质量回复.getCommand() == command) {
//                Sensor.SensorACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.背景音乐反馈.getCommand() == command) {
//                Music.Update(subnetID, deviceID, usefulBytes, command);
//            } else if (Commands.音乐播放二控制反馈.getCommand() == command) {
//                Music.MusicListACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.安防区模式控制反馈.getCommand() == command) {
//                SecurityModule.ControlSecurityACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.安防读取区模式状态反馈.getCommand() == command) {
//                SecurityModule.ReadSecurityModeACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.安防模块传感器总区数读取反馈.getCommand() == command) {
//                SecurityModule.ReadSecuritySensorCountACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.安防模块传感器状态读取反馈.getCommand() == command) {
//                SecurityModule.ReadSecuritySensorACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.安防历史记录存储地址反馈.getCommand() == command) {
//                SecurityModule.ReadSecurityHistoryACK(subnetID, deviceID, usefulBytes);
//            } else if (Commands.安防历史具体信息反馈.getCommand() == command) {
//                SecurityModule.ReadSecurityHistoryInfoACK(subnetID, deviceID, usefulBytes);
//            }
//        } catch (Exception e) {
//            Log.e(TAG, e.getMessage());
//        }
//    }
//
//    public static void Stop() {
//
//        try {
//
//            if (datagramSocket != null) {
//                datagramSocket.close();
//                datagramSocket = null;
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }
//
//    /**
//     * 发送数据的线程，读取发送缓冲区的内容进行发送
//     */
//    private static class mySendThread extends Thread {
//
//        @Override
//        public void run() {
//
//            while (true) {
//
//                SendDatas sendDatas = null;
//
//                try {
//
//                    Thread.sleep(SLEEP_TIME);
//
//                    if (datagramSocket != null) {
//
//                        if (!(SendDatas.sendDataArrayList.size() > 0))
//                            continue;
//
//                        for (int i = 0; i < SendDatas.sendDataArrayList.size(); i++) {
//
//                            sendDatas = SendDatas.sendDataArrayList.get(i);
//                            if (Global.getBusSerialPortState()) {
//                                SendDataForBusSerial(sendDatas);
//                            } else {
//                                SendDataForNetwork(sendDatas);
//                            }
//                            Thread.sleep(SLEEP_TIME);
//                        }
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * Read bus data thread
//     *
//     * @author 2017年12月19日
//     */
//    private static class BusSerialPortReadThread extends Thread {
//
//        @Override
//        public void run() {
//            super.run();
//
//            List<Byte> arrayList = new ArrayList<Byte>();
//
//            while (!isInterrupted()) {
//
//                int size = 0;
//                int subnetID = 0;// 源子网号
//                int deviceID = 0; // 源设备号
//                int desSubnetID = 0;// 目的地址
//                int desDeviceID = 0;
//
//                try {
//
//                    if (SerialPort.getBusInstantiation().getInputStream() == null) {
//                        continue;
//                    }
//
//                    byte[] buffer = new byte[64];
//                    size = SerialPort.getBusInstantiation().getInputStream().read(buffer);
//
//                    for (int i = 0; i < size; i++) {
//                        arrayList.add(buffer[i]);
//                    }
//
//                    while (0 < arrayList.size()) {
//
//                        int len = -1;
//                        int startIndex = 0;
//                        for (startIndex = 0; startIndex < arrayList.size(); startIndex++) {
//                            if ((arrayList.get(startIndex) & 0xFF) == 0xAA && (arrayList.get(startIndex + 1) & 0xFF) == 0xAA) {
//                                len = arrayList.get(startIndex + 2) + 2;
//                                break;
//                            }
//                        }
//                        if (len == -1 || arrayList.size() < len) {
//                            break;
//                        }
//
//                        for (int i = 0; i < startIndex; i++) {
//                            arrayList.remove(0);
//                        }
//                        byte[] tempBytes = new byte[len];
//                        for (int i = 0; i < tempBytes.length; i++) {
//                            tempBytes[i] = arrayList.get(0);
//                            arrayList.remove(0);
//                        }
//
//                        int command = (tempBytes[7] & 0xFF) * 256 + (tempBytes[8] & 0xFF);
//
//                        subnetID = tempBytes[3] & 0xFF;
//                        deviceID = tempBytes[4] & 0xFF;
//                        desSubnetID = tempBytes[9] & 0xFF;
//                        desDeviceID = tempBytes[10] & 0xFF;
//
//                        byte[] usefulBytes = new byte[(tempBytes[2] & 0xFF) - 11];
//
//                        // 复制附加数据
//                        System.arraycopy(tempBytes, 11, usefulBytes, 0, usefulBytes.length);
//
//                        if (Global.mReceiveData != null)
//                            Global.mReceiveData.receiveData(command, desSubnetID, desDeviceID, subnetID, deviceID, usefulBytes, null);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    private static void SendDataForNetwork(SendDatas sendDatas) {
//
//        try {
//
//            DatagramPacket packet = new DatagramPacket(sendDatas.GetSendBytes(), sendDatas.GetSendBytes().length, Global.BroadcastIP, 6000);
//            datagramSocket.send(packet);
//            //
//            sendDatas.StartCalendar = Calendar.getInstance();
//            sendDatas.SendCount++;
//            SendDatas.AddSendDataList(sendDatas);
//            SendDatas.sendDataArrayList.remove(sendDatas);
//
//        } catch (Exception e) {
//            e.getMessage();
//            SendDatas.sendDataArrayList.remove(sendDatas);
//        }
//    }
//
//    private static void SendDataForBusSerial(SendDatas sendDatas) {
//        // 串口
//        try {
//
//            SerialPort.getBusInstantiation().getOutputStream().write(sendDatas.GetSendBytes());
//            SerialPort.getBusInstantiation().getOutputStream().flush();
//            //
//            sendDatas.StartCalendar = Calendar.getInstance();
//            sendDatas.SendCount++;
//            SendDatas.AddSendDataList(sendDatas);
//            SendDatas.sendDataArrayList.remove(sendDatas);
//
//        } catch (Exception e) {
//            e.getMessage();
//            SendDatas.sendDataArrayList.remove(sendDatas);
//        }
//    }
//
//    private static class RetransmissionThread extends Thread {
//
//        @Override
//        public void run() {
//            super.run();
//            //
//            while (true) {
//
//                try {
//                    //
//                    ArrayList<SendDatas> SendDataList = SendDatas.GetSendDataList();
//
//                    synchronized (SendDataList) {
//
//                        for (int i = 0; i < SendDataList.size(); i++) {
//
//                            SendDatas sendDatas = SendDataList.get(i);
//                            if (Calendar.getInstance().getTimeInMillis() - sendDatas.StartCalendar.getTimeInMillis() < 500)
//                                continue;
//
//                            if (sendDatas.SendCount > 2) {
//                                SendDataList.remove(sendDatas);
//                            } else {
//                                // 发送Data
//                                if (Global.getBusSerialPortState()) {
//                                    SendDataForBusSerial(sendDatas);
//                                } else {
//                                    SendDataForNetwork(sendDatas);
//                                }
//                            }
//                            Thread.sleep(SLEEP_TIME);
//                        }
//                    }
//                    Thread.sleep(RETRANSMISSION_TIME);
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//            }
//        }
//    }
}
