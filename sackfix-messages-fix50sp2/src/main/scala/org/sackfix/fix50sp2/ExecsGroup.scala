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
case class ExecsGroup(lastQtyField:Option[LastQtyField]=None,
                      execIDField:Option[ExecIDField]=None,
                      secondaryExecIDField:Option[SecondaryExecIDField]=None,
                      lastPxField:Option[LastPxField]=None,
                      lastParPxField:Option[LastParPxField]=None,
                      lastCapacityField:Option[LastCapacityField]=None,
                      tradeIDField:Option[TradeIDField]=None,
                      firmTradeIDField:Option[FirmTradeIDField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    lastQtyField.foreach(fmt(b,_))
    execIDField.foreach(fmt(b,_))
    secondaryExecIDField.foreach(fmt(b,_))
    lastPxField.foreach(fmt(b,_))
    lastParPxField.foreach(fmt(b,_))
    lastCapacityField.foreach(fmt(b,_))
    tradeIDField.foreach(fmt(b,_))
    firmTradeIDField.foreach(fmt(b,_))
    b
  }

}
     
object ExecsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    LastQtyField.TagId, ExecIDField.TagId, SecondaryExecIDField.TagId, LastPxField.TagId, LastParPxField.TagId, 
    LastCapacityField.TagId, TradeIDField.TagId, FirmTradeIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==LastQtyField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[ExecsGroup]=ArrayBuffer.empty[ExecsGroup]):Option[List[ExecsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[ExecsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[ExecsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(ExecsGroup(myFields.get(LastQtyField.TagId).flatMap(f=>LastQtyField.decode(f)),
          myFields.get(ExecIDField.TagId).flatMap(f=>ExecIDField.decode(f)),
          myFields.get(SecondaryExecIDField.TagId).flatMap(f=>SecondaryExecIDField.decode(f)),
          myFields.get(LastPxField.TagId).flatMap(f=>LastPxField.decode(f)),
          myFields.get(LastParPxField.TagId).flatMap(f=>LastParPxField.decode(f)),
          myFields.get(LastCapacityField.TagId).flatMap(f=>LastCapacityField.decode(f)),
          myFields.get(TradeIDField.TagId).flatMap(f=>TradeIDField.decode(f)),
          myFields.get(FirmTradeIDField.TagId).flatMap(f=>FirmTradeIDField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     