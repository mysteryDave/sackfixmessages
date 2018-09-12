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
case class DerivativeEventsGroup(derivativeEventTypeField:Option[DerivativeEventTypeField]=None,
                                 derivativeEventDateField:Option[DerivativeEventDateField]=None,
                                 derivativeEventTimeField:Option[DerivativeEventTimeField]=None,
                                 derivativeEventPxField:Option[DerivativeEventPxField]=None,
                                 derivativeEventTextField:Option[DerivativeEventTextField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    derivativeEventTypeField.foreach(fmt(b,_))
    derivativeEventDateField.foreach(fmt(b,_))
    derivativeEventTimeField.foreach(fmt(b,_))
    derivativeEventPxField.foreach(fmt(b,_))
    derivativeEventTextField.foreach(fmt(b,_))
    b
  }

}
     
object DerivativeEventsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    DerivativeEventTypeField.TagId, DerivativeEventDateField.TagId, DerivativeEventTimeField.TagId, DerivativeEventPxField.TagId, DerivativeEventTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==DerivativeEventTypeField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[DerivativeEventsGroup]=ArrayBuffer.empty[DerivativeEventsGroup]):Option[List[DerivativeEventsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[DerivativeEventsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[DerivativeEventsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(DerivativeEventsGroup(myFields.get(DerivativeEventTypeField.TagId).flatMap(f=>DerivativeEventTypeField.decode(f)),
          myFields.get(DerivativeEventDateField.TagId).flatMap(f=>DerivativeEventDateField.decode(f)),
          myFields.get(DerivativeEventTimeField.TagId).flatMap(f=>DerivativeEventTimeField.decode(f)),
          myFields.get(DerivativeEventPxField.TagId).flatMap(f=>DerivativeEventPxField.decode(f)),
          myFields.get(DerivativeEventTextField.TagId).flatMap(f=>DerivativeEventTextField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     