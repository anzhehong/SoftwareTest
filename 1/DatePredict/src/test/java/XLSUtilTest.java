import org.junit.Before;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by fowafolo
 * Date: 16/4/8
 * Time: 10:31
 */
public class XLSUtilTest {

    XLSUtil xlsUtil;
    private static ArrayList<XLSModel> listBooks;
    static String excelFilePath = "/Users/fowafolo/百度云同步盘/Mac同步盘/Homework/软件测试/DatePredict/test.xlsx";
//    static String outFilePath = "/Users/fowafolo/百度云同步盘/Mac同步盘/Homework/软件测试/DatePredict/out2.xlsx";

    @Before
    public void before() {
        xlsUtil = new XLSUtil();
    }

    @org.junit.Test
    public void readData() throws Exception {
        listBooks = xlsUtil.readData(excelFilePath);
        assertEquals(77, listBooks.size());
    }
}