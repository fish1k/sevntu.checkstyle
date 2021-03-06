package com.puppycrawl.tools.checkstyle.checks.coding;

import com.puppycrawl.tools.checkstyle.BaseCheckTestSupport;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import java.io.File;
import org.junit.Test;

public class IllegalCatchCheckTest extends BaseCheckTestSupport
{
    @Test
    public final void testDefault() throws Exception
    {
        DefaultConfiguration checkConfig = createCheckConfig(IllegalCatchCheck.class);

        
        String[] expected = {
            "9:9: Catching 'RuntimeException' is not allowed.",
            "11:9: Catching 'java.lang.Exception' is not allowed.",
            "13:9: Catching 'Throwable' is not allowed.",       
            "24:9: Catching 'RuntimeException' is not allowed.",
            "29:9: Catching 'java.lang.Exception' is not allowed.",
            "34:9: Catching 'Throwable' is not allowed.",
        };

        //sSystem.setProperty("testinputs.dir", "/home/developer/Daniil Yaroslavtsev/sevntu.checkstyle/sevntu.checkstyle/src/testinputs/com/puppycrawl/tools/checkstyle/coding");
        
        checkConfig.addAttribute("allowThrow", "false");
        checkConfig.addAttribute("allowRethrow", "false");
        
        //verify(checkConfig, getPath("coding" + File.separator + "InputIllegalCatchCheck.java"), expected);
        verify(checkConfig,getPath("coding" + File.separator
                + "InputIllegalCatchCheckNew.java"),expected);
    }

    @Test
    public final void testThrowPermit() throws Exception
    {
        DefaultConfiguration checkConfig = createCheckConfig(IllegalCatchCheck.class);


        String[] expected = {
            "9:9: Catching 'RuntimeException' is not allowed.",
            "11:9: Catching 'java.lang.Exception' is not allowed.",
            "13:9: Catching 'Throwable' is not allowed.",
//          "24:9: Catching 'RuntimeException' is not allowed.",
            "29:9: Catching 'java.lang.Exception' is not allowed.",
            "34:9: Catching 'Throwable' is not allowed.",
        };

        //System.setProperty("testinputs.dir", "/home/developer/Daniil Yaroslavtsev/sevntu.checkstyle/sevntu.checkstyle/src/testinputs/com/puppycrawl/tools/checkstyle/coding");

        checkConfig.addAttribute("allowThrow", "true");
        checkConfig.addAttribute("allowRethrow", "false");
        
        //verify(checkConfig, getPath("coding" + File.separator + "InputIllegalCatchCheck.java"), expected);
        verify(checkConfig,getPath("coding" + File.separator
                + "InputIllegalCatchCheckNew.java"),expected);
    }
    
    @Test
    public final void testReThrowPermit() throws Exception
    {
        DefaultConfiguration checkConfig = createCheckConfig(IllegalCatchCheck.class);
        checkConfig.addAttribute("illegalClassNames",
                                 "java.lang.Error, java.lang.Exception, java.lang.Throwable");

        String[] expected = {
//          "9:9: Catching 'RuntimeException' is not allowed.",
            "11:9: Catching 'java.lang.Exception' is not allowed.",
            "13:9: Catching 'Throwable' is not allowed.",
//          "24:9: Catching 'RuntimeException' is not allowed.",
//          "29:9: Catching 'java.lang.Exception' is not allowed.",
//          "34:9: Catching 'Throwable' is not allowed.",
        };

        //System.setProperty("testinputs.dir", "/home/developer/Daniil Yaroslavtsev/sevntu.checkstyle/sevntu.checkstyle/src/testinputs/com/puppycrawl/tools/checkstyle/coding");

        checkConfig.addAttribute("allowThrow", "false");
        checkConfig.addAttribute("allowRethrow", "true");

        //verify(checkConfig, getPath("coding" + File.separator + "InputIllegalCatchCheck.java"), expected);
        verify(checkConfig,getPath("coding" + File.separator
                + "InputIllegalCatchCheckNew.java"),expected);
    }

}