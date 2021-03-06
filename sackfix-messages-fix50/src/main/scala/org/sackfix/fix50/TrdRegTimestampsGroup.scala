package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class TrdRegTimestampsGroup(trdRegTimestampField:Option[TrdRegTimestampField]=None,
                                 trdRegTimestampTypeField:Option[TrdRegTimestampTypeField]=None,
                                 trdRegTimestampOriginField:Option[TrdRegTimestampOriginField]=None,
                                 deskTypeField:Option[DeskTypeField]=None,
                                 deskTypeSourceField:Option[DeskTypeSourceField]=None,
                                 deskOrderHandlingInstField:Option[DeskOrderHandlingInstField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    trdRegTimestampField.foreach(fmt(b,_))
    trdRegTimestampTypeField.foreach(fmt(b,_))
    trdRegTimestampOriginField.foreach(fmt(b,_))
    deskTypeField.foreach(fmt(b,_))
    deskTypeSourceField.foreach(fmt(b,_))
    deskOrderHandlingInstField.foreach(fmt(b,_))
    b
  }

}
     
object TrdRegTimestampsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    TrdRegTimestampField.TagId, TrdRegTimestampTypeField.TagId, TrdRegTimestampOriginField.TagId, DeskTypeField.TagId, DeskTypeSourceField.TagId, 
    DeskOrderHandlingInstField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==TrdRegTimestampField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[TrdRegTimestampsGroup]=ArrayBuffer.empty[TrdRegTimestampsGroup]):Option[List[TrdRegTimestampsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[TrdRegTimestampsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[TrdRegTimestampsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(TrdRegTimestampsGroup(myFields.get(TrdRegTimestampField.TagId).flatMap(f=>TrdRegTimestampField.decode(f)),
          myFields.get(TrdRegTimestampTypeField.TagId).flatMap(f=>TrdRegTimestampTypeField.decode(f)),
          myFields.get(TrdRegTimestampOriginField.TagId).flatMap(f=>TrdRegTimestampOriginField.decode(f)),
          myFields.get(DeskTypeField.TagId).flatMap(f=>DeskTypeField.decode(f)),
          myFields.get(DeskTypeSourceField.TagId).flatMap(f=>DeskTypeSourceField.decode(f)),
          myFields.get(DeskOrderHandlingInstField.TagId).flatMap(f=>DeskOrderHandlingInstField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     