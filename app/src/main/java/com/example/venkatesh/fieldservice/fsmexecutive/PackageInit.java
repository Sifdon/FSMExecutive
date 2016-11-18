package com.example.venkatesh.fieldservice.fsmexecutive;

/**
 * Created by venkatesh on 15-07-2016.
 */
public class PackageInit {

    String empId;
    String email;
    String packageId;;
    String packageName;
    String status;
    public PackageInit()
    {

    }
    public PackageInit(String empId,String email,String packageId,String packageName,String status)
    {
        this.empId=empId;
        this.email=email;
        this.packageId=packageId;
        this.packageName=packageName;
        this.status=status;
    }
    public String getEmpId()
    {
        return empId;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPackageId()
    {
        return packageId;
    }
    public String getPackageName()
    {
        return packageName;
    }
    public String getStatus()
    {
        return status;
    }

}

