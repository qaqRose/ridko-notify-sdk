package com.ridkorfid.notify.client.request;

/**
 * @author qiu
 * @date 2021/1/9
 */
public interface NotifyHeader extends HttpHeader {

    String VERSION = "client_version";

    String USER_AGENT = "client_user_agent";

    String NOTIFY_TYPE = "client_notify_type";

    String SYS_NAME = "client_sys_name";

    String JDK_VERSION = "client_jdk_version";

    String RUNTIME_INFO = "client_runtime_info";

    String HOST_NAME = "client_host_name";

    String CPU_INFO = "client_cpu_info";

    String MEMORY_INFO = "client_memory_info";
}
