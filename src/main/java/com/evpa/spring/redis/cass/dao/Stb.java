package com.evpa.spring.redis.cass.dao;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Stb implements Serializable {

        private static final long serialVersionUID = -8686093905702041297L;

        @Id
        private String deviceId;
        private long checksumRecorded;
        private long checksumScheduled;
        private int hddSpaceExtFree;
        private int hddSpaceExtTotal;
        private int hddSpaceFreeIn2Weeks;
        private int hddSpaceInternalFree;
        private int hddSpaceInternalTotal;
        private Date lastRequestTime;
        private Date lastUpdated;
        private String priorityVector;
        private String seriesSchedulerPriorityVector;

        public Stb() {}

        public Stb(String deviceId, long checksumRecorded, long checksumScheduled, int hddSpaceExtFree, int hddSpaceExtTotal, int hddSpaceFreeIn2Weeks, int hddSpaceInternalFree, int hddSpaceInternalTotal, Date lastRequestTime, Date lastUpdated, String priorityVector, String seriesSchedulerPriorityVector) {
                this.deviceId = deviceId;
                this.checksumRecorded = checksumRecorded;
                this.checksumScheduled = checksumScheduled;
                this.hddSpaceExtFree = hddSpaceExtFree;
                this.hddSpaceExtTotal = hddSpaceExtTotal;
                this.hddSpaceFreeIn2Weeks = hddSpaceFreeIn2Weeks;
                this.hddSpaceInternalFree = hddSpaceInternalFree;
                this.hddSpaceInternalTotal = hddSpaceInternalTotal;
                this.lastRequestTime = lastRequestTime;
                this.lastUpdated = lastUpdated;
                this.priorityVector = priorityVector;
                this.seriesSchedulerPriorityVector = seriesSchedulerPriorityVector;
        }

        public String getDeviceId() {
                return deviceId;
        }

        public void setDeviceId(String deviceId) {
                this.deviceId = deviceId;
        }

        public long getChecksumRecorded() {
                return checksumRecorded;
        }

        public void setChecksumRecorded(long checksumRecorded) {
                this.checksumRecorded = checksumRecorded;
        }

        public long getChecksumScheduled() {
                return checksumScheduled;
        }

        public void setChecksumScheduled(long checksumScheduled) {
                this.checksumScheduled = checksumScheduled;
        }

        public int getHddSpaceExtFree() {
                return hddSpaceExtFree;
        }

        public void setHddSpaceExtFree(int hddSpaceExtFree) {
                this.hddSpaceExtFree = hddSpaceExtFree;
        }

        public int getHddSpaceExtTotal() {
                return hddSpaceExtTotal;
        }

        public void setHddSpaceExtTotal(int hddSpaceExtTotal) {
                this.hddSpaceExtTotal = hddSpaceExtTotal;
        }

        public int getHddSpaceFreeIn2Weeks() {
                return hddSpaceFreeIn2Weeks;
        }

        public void setHddSpaceFreeIn2Weeks(int hddSpaceFreeIn2Weeks) {
                this.hddSpaceFreeIn2Weeks = hddSpaceFreeIn2Weeks;
        }

        public int getHddSpaceInternalFree() {
                return hddSpaceInternalFree;
        }

        public void setHddSpaceInternalFree(int hddSpaceInternalFree) {
                this.hddSpaceInternalFree = hddSpaceInternalFree;
        }

        public int getHddSpaceInternalTotal() {
                return hddSpaceInternalTotal;
        }

        public void setHddSpaceInternalTotal(int hddSpaceInternalTotal) {
                this.hddSpaceInternalTotal = hddSpaceInternalTotal;
        }

        public Date getLastRequestTime() {
                return lastRequestTime;
        }

        public void setLastRequestTime(Date lastRequestTime) {
                this.lastRequestTime = lastRequestTime;
        }

        public Date getLastUpdated() {
                return lastUpdated;
        }

        public void setLastUpdated(Date lastUpdated) {
                this.lastUpdated = lastUpdated;
        }

        public String getPriorityVector() {
                return priorityVector;
        }

        public void setPriorityVector(String priorityVector) {
                this.priorityVector = priorityVector;
        }

        public String getSeriesSchedulerPriorityVector() {
                return seriesSchedulerPriorityVector;
        }

        public void setSeriesSchedulerPriorityVector(String seriesSchedulerPriorityVector) {
                this.seriesSchedulerPriorityVector = seriesSchedulerPriorityVector;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Stb stb = (Stb) o;
                return checksumRecorded == stb.checksumRecorded &&
                        checksumScheduled == stb.checksumScheduled &&
                        hddSpaceExtFree == stb.hddSpaceExtFree &&
                        hddSpaceExtTotal == stb.hddSpaceExtTotal &&
                        hddSpaceFreeIn2Weeks == stb.hddSpaceFreeIn2Weeks &&
                        hddSpaceInternalFree == stb.hddSpaceInternalFree &&
                        hddSpaceInternalTotal == stb.hddSpaceInternalTotal &&
                        Objects.equals(deviceId, stb.deviceId) &&
                        Objects.equals(lastRequestTime, stb.lastRequestTime) &&
                        Objects.equals(lastUpdated, stb.lastUpdated) &&
                        Objects.equals(priorityVector, stb.priorityVector) &&
                        Objects.equals(seriesSchedulerPriorityVector, stb.seriesSchedulerPriorityVector);
        }

        @Override
        public int hashCode() {

                return Objects.hash(deviceId, checksumRecorded, checksumScheduled, hddSpaceExtFree, hddSpaceExtTotal, hddSpaceFreeIn2Weeks, hddSpaceInternalFree, hddSpaceInternalTotal, lastRequestTime, lastUpdated, priorityVector, seriesSchedulerPriorityVector);
        }

        @Override
        public String toString() {
                return "Stb{" +
                        "deviceId='" + deviceId + '\'' +
                        ", checksumRecorded=" + checksumRecorded +
                        ", checksumScheduled=" + checksumScheduled +
                        ", hddSpaceExtFree=" + hddSpaceExtFree +
                        ", hddSpaceExtTotal=" + hddSpaceExtTotal +
                        ", hddSpaceFreeIn2Weeks=" + hddSpaceFreeIn2Weeks +
                        ", hddSpaceInternalFree=" + hddSpaceInternalFree +
                        ", hddSpaceInternalTotal=" + hddSpaceInternalTotal +
                        ", lastRequestTime=" + lastRequestTime +
                        ", lastUpdated=" + lastUpdated +
                        ", priorityVector='" + priorityVector + '\'' +
                        ", seriesSchedulerPriorityVector='" + seriesSchedulerPriorityVector + '\'' +
                        '}';
        }
}
