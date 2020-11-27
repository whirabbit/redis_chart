package com.fehead.chart.demos.pojo;

public class FormMessage {
  private   String projectName;
  private  String interfaceName;
  private Integer total;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "FormMessage{" +
                "projectName='" + projectName + '\'' +
                ", interfaceName='" + interfaceName + '\'' +
                ", total=" + total +
                '}';
    }
}
