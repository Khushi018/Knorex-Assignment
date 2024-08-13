package com.vastParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class VastTagParser {

    public VastTag parseXmlToVastTag(String xml) throws Exception {
    	try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(xml, VastTag.class);
        } catch (UnrecognizedPropertyException e) {
            throw new Exception("Error parsing XML data: Unrecognized property in XML input", e);
        } catch (Exception e) {
            throw new Exception("Error parsing XML", e);
        }
    }

    public String convertToJson(VastTag vastTag) throws Exception {
    	 try {
             ObjectMapper jsonMapper = new ObjectMapper();
             return jsonMapper.writeValueAsString(vastTag);
         } catch (Exception e) {
             throw new Exception("Error converting to JSON", e);
         }
    }
}
