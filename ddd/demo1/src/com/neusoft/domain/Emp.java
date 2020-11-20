package com.neusoft.domain;

import java.util.Date;

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int mgr;

    @Override
    public String toString() {
        return
                "empno=" + empno +
                        ", ename='" + ename + '\'' +
                        ", job='" + job + '\'' +
                        ", mgr=" + mgr +
                        ", hiredate=" + hiredate +
                        ", sal=" + sal +
                        ", comm=" + comm +
                        ", depyno=" + depyno;
    }

    private Date hiredate;
    private int sal;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDepyno() {
        return depyno;
    }

    public void setDepyno(int depyno) {
        this.depyno = depyno;
    }

    private int comm;
    private int depyno;

    public Emp(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int depyno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.depyno = depyno;
    }
}
