package io.github.zodh.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.springframework.format.datetime.standard.InstantFormatter;

public class DateTimeUtils {

  private DateTimeUtils() {}

  public static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

  public static String generateISO8601Timestamp() {
    var timezone = TimeZone.getTimeZone("UTC");
    var simpleDateFormate = new SimpleDateFormat(ISO_8601_PATTERN);
    simpleDateFormate.setTimeZone(timezone);
    return simpleDateFormate.format(new Date());
  }

  public static String fromEpochTimeToISO8601Timestamp(String epochDate) {
    var zoneId = "Etc/UTC";
    var offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(epochDate)),
        ZoneId.of(zoneId));
    var dateTimeFormatter = new DateTimeFormatterBuilder()
        .appendPattern(ISO_8601_PATTERN)
        .toFormatter()
        .withZone(ZoneId.of(zoneId));
    return dateTimeFormatter.format(offsetDateTime);
  }

  public static String fromISO8601TimestampToEpochTime(String iso8601Timestamp) {
    try {
      var instantEpoch = new InstantFormatter().parse(iso8601Timestamp, Locale.US).getEpochSecond();
      return String.valueOf(instantEpoch);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Invalid ISO 8601 Timestamp");
    }
  }

}
