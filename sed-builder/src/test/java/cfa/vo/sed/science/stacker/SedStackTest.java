/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfa.vo.sed.science.stacker;

import cfa.vo.iris.interop.SedSAMPController;
import cfa.vo.iris.sed.ExtSed;
import cfa.vo.sed.builder.AsciiConf;
import cfa.vo.sed.builder.SegmentImporter;
import cfa.vo.sed.setup.SetupBean;
import cfa.vo.sedlib.Segment;
import cfa.vo.sedlib.io.SedFormat;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jbudynk
 */
public class SedStackTest {
    private Segment seg1;
    private Segment seg2;
    private SedSAMPController controller;
    private SedStackerRedshifter redshifter;
    
    @Before
    public void setUp() throws Exception {
	URL filename1 = AsciiConf.class.getResource("/test_data/ascii-conf-test.dat");
	SetupBean result1 = new AsciiConf().makeConf(filename1);
	seg1 = SegmentImporter.getSegments(result1).get(0);
	
	URL filename2 = AsciiConf.class.getResource("/test_data/ascii-conf-no-y_error.dat");
	SetupBean result2 = new AsciiConf().makeConf(filename2);
	seg2 = SegmentImporter.getSegments(result2).get(0);
	
    }
    
    @After
    public void tearDown() {
	
    }
    
    @Test
    public void testRename() throws Exception {
	
	List<String> names = new ArrayList();
	names.add("Stack");
	for (int i=0; i<54; i++) {
	    add(names, "Stack");
	}
	
	add(names, "Stack");
	System.out.println(names);
	
    }
    
    @Test
    public void testAddSedsFrameAddButton() throws Exception {
	SedStack stack = new SedStack("Stack");
	ExtSed sed = new ExtSed("Sed");
	sed.addSegment(seg1);
	sed.addSegment(seg2);
	ExtSed sed2 = new ExtSed("Sed2");
	sed2.addSegment(seg1);
	sed2.addSegment(seg2);
	stack.add(sed);
	stack.add(sed2);
	
	ExtSed sed3 = new ExtSed("Sed3");
	sed3.addSegment(seg1);
	sed3.addSegment(seg2);
	List<ExtSed> newSedList = new ArrayList();
	newSedList.add(sed3);
	
	addSedsFrame(stack, newSedList, false);
	
	System.out.println("");
    }
    
    public void add(List<String> names, String newName) {
	
	char c = '@';
	int i = 1;
	int j = 1;
        while (names.contains(newName + (c == '@' ? "" : "." + StringUtils.repeat(String.valueOf(c), j)))) {
	    int val = j*26;
	    if (i % val == 0) {
		c = '@';
		j++;
	    }
	    c++;
	    i++;
        }
        names.add(newName + (c == '@' ? "" : "." + StringUtils.repeat(String.valueOf(c), j)));
	
    }
    
    public void addSedsFrame(SedStack stack, List<ExtSed> seds, boolean isSegmentAsSeds) throws Exception {
	for (ExtSed sed : seds) {
	    
	    if (!isSegmentAsSeds) {
		
		stack.add(sed);
		
	    } else {

		for (int j=0; j<sed.getNumberOfSegments(); j++) {

		    Segment seg = sed.getSegment(j);
		    ExtSed nsed = new ExtSed(seg.getTarget().getName().getName());
		    nsed.addSegment(seg);
		    stack.add(nsed);

		}
	    }
	}
    }
    
}