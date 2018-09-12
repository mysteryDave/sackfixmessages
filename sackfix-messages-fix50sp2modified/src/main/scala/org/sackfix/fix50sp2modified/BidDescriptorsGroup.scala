package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class BidDescriptorsGroup(bidDescriptorTypeField:Option[BidDescriptorTypeField]=None,
                               bidDescriptorField:Option[BidDescriptorField]=None,
                               sideValueIndField:Option[SideValueIndField]=None,
                               liquidityValueField:Option[LiquidityValueField]=None,
                               liquidityNumSecuritiesField:Option[LiquidityNumSecuritiesField]=None,
                               liquidityPctLowField:Option[LiquidityPctLowField]=None,
                               liquidityPctHighField:Option[LiquidityPctHighField]=None,
                               eFPTrackingErrorField:Option[EFPTrackingErrorField]=None,
                               fairValueField:Option[FairValueField]=None,
                               outsideIndexPctField:Option[OutsideIndexPctField]=None,
                               valueOfFuturesField:Option[ValueOfFuturesField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    bidDescriptorTypeField.foreach(fmt(b,_))
    bidDescriptorField.foreach(fmt(b,_))
    sideValueIndField.foreach(fmt(b,_))
    liquidityValueField.foreach(fmt(b,_))
    liquidityNumSecuritiesField.foreach(fmt(b,_))
    liquidityPctLowField.foreach(fmt(b,_))
    liquidityPctHighField.foreach(fmt(b,_))
    eFPTrackingErrorField.foreach(fmt(b,_))
    fairValueField.foreach(fmt(b,_))
    outsideIndexPctField.foreach(fmt(b,_))
    valueOfFuturesField.foreach(fmt(b,_))
    b
  }

}
     
object BidDescriptorsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    BidDescriptorTypeField.TagId, BidDescriptorField.TagId, SideValueIndField.TagId, LiquidityValueField.TagId, LiquidityNumSecuritiesField.TagId, 
    LiquidityPctLowField.TagId, LiquidityPctHighField.TagId, EFPTrackingErrorField.TagId, FairValueField.TagId, OutsideIndexPctField.TagId, 
    ValueOfFuturesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==BidDescriptorTypeField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[BidDescriptorsGroup]=ArrayBuffer.empty[BidDescriptorsGroup]):Option[List[BidDescriptorsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[BidDescriptorsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[BidDescriptorsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(BidDescriptorsGroup(myFields.get(BidDescriptorTypeField.TagId).flatMap(f=>BidDescriptorTypeField.decode(f)),
          myFields.get(BidDescriptorField.TagId).flatMap(f=>BidDescriptorField.decode(f)),
          myFields.get(SideValueIndField.TagId).flatMap(f=>SideValueIndField.decode(f)),
          myFields.get(LiquidityValueField.TagId).flatMap(f=>LiquidityValueField.decode(f)),
          myFields.get(LiquidityNumSecuritiesField.TagId).flatMap(f=>LiquidityNumSecuritiesField.decode(f)),
          myFields.get(LiquidityPctLowField.TagId).flatMap(f=>LiquidityPctLowField.decode(f)),
          myFields.get(LiquidityPctHighField.TagId).flatMap(f=>LiquidityPctHighField.decode(f)),
          myFields.get(EFPTrackingErrorField.TagId).flatMap(f=>EFPTrackingErrorField.decode(f)),
          myFields.get(FairValueField.TagId).flatMap(f=>FairValueField.decode(f)),
          myFields.get(OutsideIndexPctField.TagId).flatMap(f=>OutsideIndexPctField.decode(f)),
          myFields.get(ValueOfFuturesField.TagId).flatMap(f=>ValueOfFuturesField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     