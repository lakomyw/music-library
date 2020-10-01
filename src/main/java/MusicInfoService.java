import database.Slip;
import database.SlipDao;

import http.SlipDTo;
import java.util.List;

public class MusicInfoService {
    public void saveAlbum(SlipDTo slip){
        Slip slipToSave = new Slip(slip);
        SlipDao slipDao = new SlipDao();
        slipDao.insertOrUpdate(slipToSave);
    }

    public static List<Slip> getAllAlbum(){
        SlipDao slipDao = new SlipDao();
        List<Slip> slips = slipDao.getAll();
        return slips;
    }

    public void deleteID(Long Id) {
        SlipDao slipDao = new SlipDao();
        System.out.println("Succes: " + slipDao.deleteId(Id));
    }
}
