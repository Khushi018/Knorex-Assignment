package com.vastParser;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name = "Ad")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VastTag {
    private String version;
    private String id;
    private String title;
    private String description;
    private Impression impression;
    private List<Creative> creatives;

    // Getters and setters

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Impression getImpression() {
        return impression;
    }

    public void setImpression(Impression impression) {
        this.impression = impression;
    }

    public List<Creative> getCreatives() {
        return creatives;
    }

    public void setCreatives(List<Creative> creatives) {
        this.creatives = creatives;
    }

    public static class Impression {
        private String id;
        private String url;

        // Getters and setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Creative {
        private String id;
        private List<CompanionBanner> companionBanners;
        private CreativeDetail creative;

        // Getters and setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<CompanionBanner> getCompanionBanners() {
            return companionBanners;
        }

        public void setCompanionBanners(List<CompanionBanner> companionBanners) {
            this.companionBanners = companionBanners;
        }

        public CreativeDetail getCreative() {
            return creative;
        }

        public void setCreative(CreativeDetail creative) {
            this.creative = creative;
        }

        public static class CompanionBanner {
            private String id;
            private int width;
            private int height;
            private String type;
            private String clickThroughUrl;

            // Getters and setters

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getClickThroughUrl() {
                return clickThroughUrl;
            }

            public void setClickThroughUrl(String clickThroughUrl) {
                this.clickThroughUrl = clickThroughUrl;
            }
        }

        public static class CreativeDetail {
            private int duration;
            private List<MediaFile> mediaFiles;
            private List<TrackingEvent> trackingEvents;
            private List<VideoClick> videoClicks;

            // Getters and setters

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public List<MediaFile> getMediaFiles() {
                return mediaFiles;
            }

            public void setMediaFiles(List<MediaFile> mediaFiles) {
                this.mediaFiles = mediaFiles;
            }

            public List<TrackingEvent> getTrackingEvents() {
                return trackingEvents;
            }

            public void setTrackingEvents(List<TrackingEvent> trackingEvents) {
                this.trackingEvents = trackingEvents;
            }

            public List<VideoClick> getVideoClicks() {
                return videoClicks;
            }

            public void setVideoClicks(List<VideoClick> videoClicks) {
                this.videoClicks = videoClicks;
            }

            public static class MediaFile {
                private String type;
                private int bitrate;
                private int width;
                private int height;
                private String source;

                // Getters and setters

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }
            }

            public static class TrackingEvent {
                private String type;
                private String url;

                // Getters and setters

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class VideoClick {
                private String id;
                private String url;

                // Getters and setters

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
