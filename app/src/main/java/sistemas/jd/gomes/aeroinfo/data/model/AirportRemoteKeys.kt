package sistemas.jd.gomes.aeroinfo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import sistemas.jd.gomes.aeroinfo.util.Constants.AIRPORT_REMOTE_KEYS_DATABASE_TABLE


@Entity(tableName = AIRPORT_REMOTE_KEYS_DATABASE_TABLE)
data class AirportRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)