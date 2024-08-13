package com.vastParser;


public class Main {
    public static void main(String[] args) {
        VastParser parser = new VastParser();
        VastTagParser tagParser = new VastTagParser();
        DatabaseUtil dbUtil = new DatabaseUtil();
        
        

        try {
            // Read XML from URL
            String xml = "<VAST version=\"3.0\">\r\n"
            		+ "    <Ad id=\"20004\">\r\n"
            		+ "        <InLine>\r\n"
            		+ "            <AdSystem version=\"4.0\">iabtechlab</AdSystem>\r\n"
            		+ "\r\n"
            		+ "            <AdTitle>\r\n"
            		+ "                <![CDATA[VAST 4.0 Pilot - Scenario 5]]>\r\n"
            		+ "            </AdTitle>\r\n"
            		+ "            <Description>\r\n"
            		+ "                <![CDATA[This is sample companion ad tag with Linear ad tag. This tag while showing video ad on the player, will show a companion ad beside the player where it can be fitted. At most 3 companion ads can be placed. Modify accordingly to see your own content.]]>\r\n"
            		+ "            </Description>\r\n"
            		+ "\r\n"
            		+ "            <Pricing model=\"cpm\" currency=\"USD\">\r\n"
            		+ "                <![CDATA[ 25.00 ]]>\r\n"
            		+ "            </Pricing>\r\n"
            		+ "\r\n"
            		+ "            <Error>http://example.com/error</Error>\r\n"
            		+ "            <Impression id=\"Impression-ID\">http://example.com/track/impression</Impression>\r\n"
            		+ "\r\n"
            		+ "            <Creatives>\r\n"
            		+ "                <Creative id=\"5480\" sequence=\"1\">\r\n"
            		+ "                    <CompanionAds>\r\n"
            		+ "                        <Companion id=\"1232\" width=\"300\" height=\"250\" assetWidth=\"250\" assetHeight=\"200\" expandedWidth=\"350\" expandedHeight=\"250\">\r\n"
            		+ "                               <StaticResource creativeType=\"image/png\">\r\n"
            		+ "                                <![CDATA[https://www.iab.com/wp-content/uploads/2014/09/iab-tech-lab-6-644x290.png]]>\r\n"
            		+ "                                </StaticResource>\r\n"
            		+ "                                <CompanionClickThrough>\r\n"
            		+ "                                    <![CDATA[https://iabtechlab.com]]>\r\n"
            		+ "                                </CompanionClickThrough>\r\n"
            		+ "                        </Companion>\r\n"
            		+ "                    </CompanionAds>\r\n"
            		+ "                </Creative>\r\n"
            		+ "                <Creative id=\"5480\" sequence=\"1\">\r\n"
            		+ "                    <Linear>\r\n"
            		+ "                        <Duration>00:00:16</Duration>\r\n"
            		+ "                        <TrackingEvents>\r\n"
            		+ "                            <Tracking event=\"start\">http://example.com/tracking/start</Tracking>\r\n"
            		+ "                            <Tracking event=\"firstQuartile\">http://example.com/tracking/firstQuartile</Tracking>\r\n"
            		+ "                            <Tracking event=\"midpoint\">http://example.com/tracking/midpoint</Tracking>\r\n"
            		+ "                            <Tracking event=\"thirdQuartile\">http://example.com/tracking/thirdQuartile</Tracking>\r\n"
            		+ "                            <Tracking event=\"complete\">http://example.com/tracking/complete</Tracking>\r\n"
            		+ "                            <Tracking event=\"progress\" offset=\"00:00:10\">http://example.com/tracking/progress-10</Tracking>\r\n"
            		+ "                        </TrackingEvents>\r\n"
            		+ "\r\n"
            		+ "                        <VideoClicks>\r\n"
            		+ "                            <ClickTracking id=\"blog\">\r\n"
            		+ "                                <![CDATA[https://iabtechlab.com]]>\r\n"
            		+ "                            </ClickTracking>\r\n"
            		+ "                        </VideoClicks>\r\n"
            		+ "\r\n"
            		+ "                        <MediaFiles>\r\n"
            		+ "                            <MediaFile id=\"5241\" delivery=\"progressive\" type=\"video/mp4\" bitrate=\"500\" width=\"400\" height=\"300\" minBitrate=\"360\" maxBitrate=\"1080\" scalable=\"1\" maintainAspectRatio=\"1\" codec=\"0\">\r\n"
            		+ "                                <![CDATA[https://iab-publicfiles.s3.amazonaws.com/vast/VAST-4.0-Short-Intro.mp4]]>\r\n"
            		+ "                            </MediaFile>\r\n"
            		+ "                        </MediaFiles>\r\n"
            		+ "                    </Linear>\r\n"
            		+ "                </Creative>\r\n"
            		+ "\r\n"
            		+ "            </Creatives>\r\n"
            		+ "            <Extensions>\r\n"
            		+ "                <Extension type=\"iab-Count\">\r\n"
            		+ "                    <total_available>\r\n"
            		+ "                        <![CDATA[ 2 ]]>\r\n"
            		+ "                    </total_available>\r\n"
            		+ "                </Extension>\r\n"
            		+ "            </Extensions>\r\n"
            		+ "        </InLine>\r\n"
            		+ "    </Ad>\r\n"
            		+ "</VAST>";
           
            
            System.out.println("xml start--------------------");
            
            System.out.println(xml);
            System.out.println("xml end----------------------");
            
            // Parse XML to VAST Tag
            VastTag vastTag = tagParser.parseXmlToVastTag(xml);
            
            // Convert to JSON and print
            String json = tagParser.convertToJson(vastTag);
            System.out.println(json);
            
            // Save to Database
            dbUtil.saveVastTag(vastTag);
            
            // Retrieve from Database
            VastTag retrievedTag = dbUtil.getVastTagById(vastTag.getId());
            System.out.println("Retrieved VAST Tag: " + tagParser.convertToJson(retrievedTag));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
