// automatically generated by the FlatBuffers compiler, do not modify

package flatbuffers;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class DateTimeFbs extends Struct {
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public DateTimeFbs __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int day() { return bb.get(bb_pos + 0) & 0xFF; }
  public int month() { return bb.get(bb_pos + 1) & 0xFF; }
  public int year() { return bb.getShort(bb_pos + 2) & 0xFFFF; }
  public int hour() { return bb.get(bb_pos + 4) & 0xFF; }
  public int minute() { return bb.get(bb_pos + 5) & 0xFF; }
  public int second() { return bb.get(bb_pos + 6) & 0xFF; }

  public static int createDateTimeFbs(FlatBufferBuilder builder, int day, int month, int year, int hour, int minute, int second) {
    builder.prep(2, 8);
    builder.pad(1);
    builder.putByte((byte) second);
    builder.putByte((byte) minute);
    builder.putByte((byte) hour);
    builder.putShort((short) year);
    builder.putByte((byte) month);
    builder.putByte((byte) day);
    return builder.offset();
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public DateTimeFbs get(int j) { return get(new DateTimeFbs(), j); }
    public DateTimeFbs get(DateTimeFbs obj, int j) {  return obj.__assign(__element(j), bb); }
  }
}

