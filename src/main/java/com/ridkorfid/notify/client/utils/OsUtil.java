package com.ridkorfid.notify.client.utils;

import cn.hutool.core.io.unit.DataSize;
import cn.hutool.system.*;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import oshi.hardware.GlobalMemory;
import oshi.hardware.VirtualMemory;

import java.text.DecimalFormat;

/**
 * @author qiu
 * @date 2021/5/7
 */
public class OsUtil {

    /**
     * host name
     * @return
     */
    public static String getHostName() {
        return SystemUtil.getHostInfo().getName();
    }

    /**
     * 地址
     * @return
     */
    public static String getHostAddress() {
        return SystemUtil.getHostInfo().getAddress();
    }

    /**
     * 系统名称
     * @return
     */
    public static String getSystemName() {
        return SystemUtil.getOsInfo().getName();
    }

    /**
     * JDK的版本
     * @return
     */
    public static String getJdkVersion() {
        return SystemUtil.getJavaInfo().getVersion();
    }

    /**
     * jdk提供商
     * @return
     */
    public static String getJdkVendor() {
        return SystemUtil.getJavaInfo().getVendor();
    }

    /**
     * 运行时内容信息
     * @return
     */
    public static String getRuntimeInfo() {
        RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
        String s = runtimeInfo.toString().replaceAll("\n", "");
        return s;
    }

    /**
     * 获取cpu信息
     * @return
     */
    public static String getCpuInfo() {
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
        DecimalFormat format = new DecimalFormat("#.00");
        return "Cpu信息: {" +
                "cpu核心数=" + cpuInfo.getCpuNum() +
                ", CPU总的使用率=" + cpuInfo.getToTal() +
                ", CPU系统使用率=" + cpuInfo.getSys() +
                ", CPU用户使用率=" + cpuInfo.getUsed() +
                ", CPU当前等待率=" + cpuInfo.getWait() +
                ", CPU当前空闲率=" + cpuInfo.getFree() +
                ", CPU利用率=" + Double.parseDouble(format.format((100 - cpuInfo.getFree()))) +
                "}".replaceAll("\n", "");
    }

    /**
     * 简单信息, 严格k-v 逗号分隔
     * @return
     */
    public static String getSimpleCpuInfo() {
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
        DecimalFormat format = new DecimalFormat("#.00");
        return "core=" + cpuInfo.getCpuNum() +
                ",all_used=" + cpuInfo.getToTal() +
                ",sys_used=" + cpuInfo.getSys() +
                ",user_used=" + cpuInfo.getUsed() +
                ",wait=" + cpuInfo.getWait() +
                ",free=" + cpuInfo.getFree() +
                ",used=" + Double.parseDouble(format.format((100 - cpuInfo.getFree()))) +
                "".replaceAll("\n", "");
    }

    /**
     * 获取内存信息
     * @return
     */
    public static String getMemoryInfo() {
        GlobalMemory memory = OshiUtil.getMemory();
        // 最大内存 byte
        long total = memory.getTotal();
        // 可用内存
        long available = memory.getAvailable();
        // 虚拟内存
        VirtualMemory virtualMemory = memory.getVirtualMemory();
        // 交换区
        long swapTotal = virtualMemory.getSwapTotal();
        // 最大虚拟内存
        long virtualMax = virtualMemory.getVirtualMax();
        // 已使用虚拟内存
        long virtualInUse = virtualMemory.getVirtualInUse();

        return "内存信息: {" +
                "物理内存:" + DataSize.ofBytes(total).toMegabytes() + " MB" +
                ", 可用内存:" + DataSize.ofBytes(available).toMegabytes() + " MB" +
                ", 交换区:" + DataSize.ofBytes(swapTotal).toMegabytes() + " MB" +
                ", 最大虚拟内存:" + DataSize.ofBytes(virtualMax).toMegabytes() + " MB" +
                ", 已使用虚拟内存:" + DataSize.ofBytes(virtualInUse).toMegabytes() + " MB" +
                "}".replaceAll("\n", "");

    }

    public static String getSimpleMemoryInfo() {
        GlobalMemory memory = OshiUtil.getMemory();
        // 最大内存 byte
        long total = memory.getTotal();
        // 可用内存
        long available = memory.getAvailable();
        // 虚拟内存
        VirtualMemory virtualMemory = memory.getVirtualMemory();
        // 交换区
        long swapTotal = virtualMemory.getSwapTotal();
        // 最大虚拟内存
        long virtualMax = virtualMemory.getVirtualMax();
        // 已使用虚拟内存
        long virtualInUse = virtualMemory.getVirtualInUse();

        return "physical_memory:" + DataSize.ofBytes(total).toMegabytes() + "MB" +
                ",available_memory:" + DataSize.ofBytes(available).toMegabytes() + "MB" +
                ",swap_total:" + DataSize.ofBytes(swapTotal).toMegabytes() + "MB" +
                ",max_virtual_total:" + DataSize.ofBytes(virtualMax).toMegabytes() + "MB" +
                ",virtual_in_use:" + DataSize.ofBytes(virtualInUse).toMegabytes() + "MB" +
                "".replaceAll("\n", "");
    }

    public static void main(String[] args) {
        HostInfo hostInfo = SystemUtil.getHostInfo();

        JvmInfo jvmInfo = SystemUtil.getJvmInfo();
        JvmSpecInfo jvmSpecInfo = SystemUtil.getJvmSpecInfo();

        JavaInfo javaInfo = SystemUtil.getJavaInfo();
        JavaRuntimeInfo javaRuntimeInfo = SystemUtil.getJavaRuntimeInfo();
        JavaSpecInfo javaSpecInfo = SystemUtil.getJavaSpecInfo();
        RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
        UserInfo userInfo = SystemUtil.getUserInfo();

        for (String arg : args) {
            System.out.println(arg);

        }

        System.out.println(hostInfo);
        System.out.println(javaInfo);
        System.out.println(userInfo);
        System.out.println(jvmInfo);
        System.out.println(jvmSpecInfo);
        System.out.println(javaRuntimeInfo);
        System.out.println(javaSpecInfo);
        System.out.println(runtimeInfo);
    }
}
