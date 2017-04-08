package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class DistribInstsGroup(distribPaymentMethodField:Option[DistribPaymentMethodField]=None,
                             distribPercentageField:Option[DistribPercentageField]=None,
                             cashDistribCurrField:Option[CashDistribCurrField]=None,
                             cashDistribAgentNameField:Option[CashDistribAgentNameField]=None,
                             cashDistribAgentCodeField:Option[CashDistribAgentCodeField]=None,
                             cashDistribAgentAcctNumberField:Option[CashDistribAgentAcctNumberField]=None,
                             cashDistribPayRefField:Option[CashDistribPayRefField]=None,
                             cashDistribAgentAcctNameField:Option[CashDistribAgentAcctNameField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    distribPaymentMethodField.foreach(fmt(b,_))
    distribPercentageField.foreach(fmt(b,_))
    cashDistribCurrField.foreach(fmt(b,_))
    cashDistribAgentNameField.foreach(fmt(b,_))
    cashDistribAgentCodeField.foreach(fmt(b,_))
    cashDistribAgentAcctNumberField.foreach(fmt(b,_))
    cashDistribPayRefField.foreach(fmt(b,_))
    cashDistribAgentAcctNameField.foreach(fmt(b,_))
    b
  }

}
     
object DistribInstsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    DistribPaymentMethodField.TagId, DistribPercentageField.TagId, CashDistribCurrField.TagId, CashDistribAgentNameField.TagId, CashDistribAgentCodeField.TagId, 
    CashDistribAgentAcctNumberField.TagId, CashDistribPayRefField.TagId, CashDistribAgentAcctNameField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==DistribPaymentMethodField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[DistribInstsGroup]=ArrayBuffer.empty[DistribInstsGroup]):Option[List[DistribInstsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[DistribInstsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[DistribInstsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(DistribInstsGroup(myFields.get(DistribPaymentMethodField.TagId).flatMap(f=>DistribPaymentMethodField.decode(f)),
          myFields.get(DistribPercentageField.TagId).flatMap(f=>DistribPercentageField.decode(f)),
          myFields.get(CashDistribCurrField.TagId).flatMap(f=>CashDistribCurrField.decode(f)),
          myFields.get(CashDistribAgentNameField.TagId).flatMap(f=>CashDistribAgentNameField.decode(f)),
          myFields.get(CashDistribAgentCodeField.TagId).flatMap(f=>CashDistribAgentCodeField.decode(f)),
          myFields.get(CashDistribAgentAcctNumberField.TagId).flatMap(f=>CashDistribAgentAcctNumberField.decode(f)),
          myFields.get(CashDistribPayRefField.TagId).flatMap(f=>CashDistribPayRefField.decode(f)),
          myFields.get(CashDistribAgentAcctNameField.TagId).flatMap(f=>CashDistribAgentAcctNameField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     