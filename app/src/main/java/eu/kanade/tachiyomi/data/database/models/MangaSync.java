package eu.kanade.tachiyomi.data.database.models;

import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import java.io.Serializable;

import eu.kanade.tachiyomi.data.database.tables.MangaSyncTable;
import eu.kanade.tachiyomi.data.mangasync.base.MangaSyncService;

@StorIOSQLiteType(table = MangaSyncTable.TABLE)
public class MangaSync implements Serializable {

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_ID, key = true)
    public Long id;

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_MANGA_ID)
    public long manga_id;

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_SYNC_ID)
    public int sync_id;

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_REMOTE_ID)
    public int remote_id;

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_TITLE)
    public String title;

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_LAST_CHAPTER_READ)
    public int last_chapter_read;

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_TOTAL_CHAPTERS)
    public int total_chapters;

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_SCORE)
    public float score;

    @StorIOSQLiteColumn(name = MangaSyncTable.COLUMN_STATUS)
    public int status;

    public boolean update;

    public static MangaSync create(MangaSyncService service) {
        MangaSync mangasync = new MangaSync();
        mangasync.sync_id = service.getId();
        return mangasync;
    }

    public void copyPersonalFrom(MangaSync other) {
        last_chapter_read = other.last_chapter_read;
        score = other.score;
        status = other.status;
    }

}
