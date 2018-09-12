package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class ComplexEventsGroup(complexEventTypeField:Option[ComplexEventTypeField]=None,
                              complexOptPayoutAmountField:Option[ComplexOptPayoutAmountField]=None,
                              complexEventPriceField:Option[ComplexEventPriceField]=None,
                              complexEventPriceBoundaryMethodField:Option[ComplexEventPriceBoundaryMethodField]=None,
                              complexEventPriceBoundaryPrecisionField:Option[ComplexEventPriceBoundaryPrecisionField]=None,
                              complexEventPriceTimeTypeField:Option[ComplexEventPriceTimeTypeField]=None,
                              complexEventConditionField:Option[ComplexEventConditionField]=None,
                              complexEventDatesComponent:Option[ComplexEventDatesComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    complexEventTypeField.foreach(fmt(b,_))
    complexOptPayoutAmountField.foreach(fmt(b,_))
    complexEventPriceField.foreach(fmt(b,_))
    complexEventPriceBoundaryMethodField.foreach(fmt(b,_))
    complexEventPriceBoundaryPrecisionField.foreach(fmt(b,_))
    complexEventPriceTimeTypeField.foreach(fmt(b,_))
    complexEventConditionField.foreach(fmt(b,_))
    complexEventDatesComponent.foreach(fmt(b,_))
    b
  }

}
     
object ComplexEventsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ComplexEventDatesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ComplexEventTypeField.TagId, ComplexOptPayoutAmountField.TagId, ComplexEventPriceField.TagId, ComplexEventPriceBoundaryMethodField.TagId, ComplexEventPriceBoundaryPrecisionField.TagId, 
    ComplexEventPriceTimeTypeField.TagId, ComplexEventConditionField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ComplexEventDatesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ComplexEventDatesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ComplexEventTypeField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[ComplexEventsGroup]=ArrayBuffer.empty[ComplexEventsGroup]):Option[List[ComplexEventsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[ComplexEventsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[ComplexEventsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(ComplexEventsGroup(myFields.get(ComplexEventTypeField.TagId).flatMap(f=>ComplexEventTypeField.decode(f)),
          myFields.get(ComplexOptPayoutAmountField.TagId).flatMap(f=>ComplexOptPayoutAmountField.decode(f)),
          myFields.get(ComplexEventPriceField.TagId).flatMap(f=>ComplexEventPriceField.decode(f)),
          myFields.get(ComplexEventPriceBoundaryMethodField.TagId).flatMap(f=>ComplexEventPriceBoundaryMethodField.decode(f)),
          myFields.get(ComplexEventPriceBoundaryPrecisionField.TagId).flatMap(f=>ComplexEventPriceBoundaryPrecisionField.decode(f)),
          myFields.get(ComplexEventPriceTimeTypeField.TagId).flatMap(f=>ComplexEventPriceTimeTypeField.decode(f)),
          myFields.get(ComplexEventConditionField.TagId).flatMap(f=>ComplexEventConditionField.decode(f)),
          ComplexEventDatesComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     