package cn.xq.festec.banxiaappuser20.model.department;

import android.os.Parcel;
import android.os.Parcelable;

public class Department implements Parcelable {

    private int depId;
    private String depNum;
    private String depName;
    private String depIntro;
    private String depExtra;
    private String createdAt;

    protected Department(Parcel in) {
        depId = in.readInt();
        depNum = in.readString();
        depName = in.readString();
        depIntro = in.readString();
        depExtra = in.readString();
        createdAt = in.readString();
    }

    public static final Creator<Department> CREATOR = new Creator<Department>() {
        @Override
        public Department createFromParcel(Parcel in) {
            return new Department(in);
        }

        @Override
        public Department[] newArray(int size) {
            return new Department[size];
        }
    };

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepNum() {
        return depNum;
    }

    public void setDepNum(String depNum) {
        this.depNum = depNum;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepIntro() {
        return depIntro;
    }

    public void setDepIntro(String depIntro) {
        this.depIntro = depIntro;
    }

    public String getDepExtra() {
        return depExtra;
    }

    public void setDepExtra(String depExtra) {
        this.depExtra = depExtra;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(depId);
        parcel.writeString(depNum);
        parcel.writeString(depName);
        parcel.writeString(depIntro);
        parcel.writeString(depExtra);
        parcel.writeString(createdAt);
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depNum='" + depNum + '\'' +
                ", depName='" + depName + '\'' +
                ", depIntro='" + depIntro + '\'' +
                ", depExtra='" + depExtra + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
