package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class MiscFeesGroup(miscFeeAmtField:Option[MiscFeeAmtField]=None,
                         miscFeeCurrField:Option[MiscFeeCurrField]=None,
                         miscFeeTypeField:Option[MiscFeeTypeField]=None,
                         miscFeeBasisField:Option[MiscFeeBasisField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    miscFeeAmtField.foreach(fmt(b,_))
    miscFeeCurrField.foreach(fmt(b,_))
    miscFeeTypeField.foreach(fmt(b,_))
    miscFeeBasisField.foreach(fmt(b,_))
    b
  }

}
     
object MiscFeesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    MiscFeeAmtField.TagId, MiscFeeCurrField.TagId, MiscFeeTypeField.TagId, MiscFeeBasisField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MiscFeeAmtField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[MiscFeesGroup]=ArrayBuffer.empty[MiscFeesGroup]):Option[List[MiscFeesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[MiscFeesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[MiscFeesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(MiscFeesGroup(myFields.get(MiscFeeAmtField.TagId).flatMap(f=>MiscFeeAmtField.decode(f)),
          myFields.get(MiscFeeCurrField.TagId).flatMap(f=>MiscFeeCurrField.decode(f)),
          myFields.get(MiscFeeTypeField.TagId).flatMap(f=>MiscFeeTypeField.decode(f)),
          myFields.get(MiscFeeBasisField.TagId).flatMap(f=>MiscFeeBasisField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     