package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class SecurityListUpdateReportMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                           securityReportIDField:Option[SecurityReportIDField]=None,
                                           securityListIDField:Option[SecurityListIDField]=None,
                                           securityListRefIDField:Option[SecurityListRefIDField]=None,
                                           securityListDescField:Option[SecurityListDescField]=None,
                                           encodedSecurityListDescLenField:Option[EncodedSecurityListDescLenField]=None,
                                           encodedSecurityListDescField:Option[EncodedSecurityListDescField]=None,
                                           securityListTypeField:Option[SecurityListTypeField]=None,
                                           securityListTypeSourceField:Option[SecurityListTypeSourceField]=None,
                                           securityReqIDField:Option[SecurityReqIDField]=None,
                                           securityResponseIDField:Option[SecurityResponseIDField]=None,
                                           securityRequestResultField:Option[SecurityRequestResultField]=None,
                                           totNoRelatedSymField:Option[TotNoRelatedSymField]=None,
                                           clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                           securityUpdateActionField:Option[SecurityUpdateActionField]=None,
                                           corporateActionField:Option[CorporateActionField]=None,
                                           marketIDField:Option[MarketIDField]=None,
                                           marketSegmentIDField:Option[MarketSegmentIDField]=None,
                                           transactTimeField:Option[TransactTimeField]=None,
                                           lastFragmentField:Option[LastFragmentField]=None,
                                           secLstUpdRelSymGrpComponent:Option[SecLstUpdRelSymGrpComponent]=None) extends SfFixMessageBody("BK")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    securityReportIDField.foreach(fmt(b,_))
    securityListIDField.foreach(fmt(b,_))
    securityListRefIDField.foreach(fmt(b,_))
    securityListDescField.foreach(fmt(b,_))
    encodedSecurityListDescLenField.foreach(fmt(b,_))
    encodedSecurityListDescField.foreach(fmt(b,_))
    securityListTypeField.foreach(fmt(b,_))
    securityListTypeSourceField.foreach(fmt(b,_))
    securityReqIDField.foreach(fmt(b,_))
    securityResponseIDField.foreach(fmt(b,_))
    securityRequestResultField.foreach(fmt(b,_))
    totNoRelatedSymField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    securityUpdateActionField.foreach(fmt(b,_))
    corporateActionField.foreach(fmt(b,_))
    marketIDField.foreach(fmt(b,_))
    marketSegmentIDField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    secLstUpdRelSymGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object SecurityListUpdateReportMessage extends SfFixMessageDecoder {
  val MsgType="BK"
  val MsgName="SecurityListUpdateReport"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || SecLstUpdRelSymGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecurityReportIDField.TagId, SecurityListIDField.TagId, SecurityListRefIDField.TagId, SecurityListDescField.TagId, EncodedSecurityListDescLenField.TagId, 
    EncodedSecurityListDescField.TagId, SecurityListTypeField.TagId, SecurityListTypeSourceField.TagId, SecurityReqIDField.TagId, SecurityResponseIDField.TagId, 
    SecurityRequestResultField.TagId, TotNoRelatedSymField.TagId, ClearingBusinessDateField.TagId, SecurityUpdateActionField.TagId, CorporateActionField.TagId, 
    MarketIDField.TagId, MarketSegmentIDField.TagId, TransactTimeField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || SecLstUpdRelSymGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || SecLstUpdRelSymGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityListUpdateReportMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(SecurityReportIDField.TagId).flatMap(f=>SecurityReportIDField.decode(f)),
        myFields.get(SecurityListIDField.TagId).flatMap(f=>SecurityListIDField.decode(f)),
        myFields.get(SecurityListRefIDField.TagId).flatMap(f=>SecurityListRefIDField.decode(f)),
        myFields.get(SecurityListDescField.TagId).flatMap(f=>SecurityListDescField.decode(f)),
        myFields.get(EncodedSecurityListDescLenField.TagId).flatMap(f=>EncodedSecurityListDescLenField.decode(f)),
        myFields.get(EncodedSecurityListDescField.TagId).flatMap(f=>EncodedSecurityListDescField.decode(f)),
        myFields.get(SecurityListTypeField.TagId).flatMap(f=>SecurityListTypeField.decode(f)),
        myFields.get(SecurityListTypeSourceField.TagId).flatMap(f=>SecurityListTypeSourceField.decode(f)),
        myFields.get(SecurityReqIDField.TagId).flatMap(f=>SecurityReqIDField.decode(f)),
        myFields.get(SecurityResponseIDField.TagId).flatMap(f=>SecurityResponseIDField.decode(f)),
        myFields.get(SecurityRequestResultField.TagId).flatMap(f=>SecurityRequestResultField.decode(f)),
        myFields.get(TotNoRelatedSymField.TagId).flatMap(f=>TotNoRelatedSymField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(SecurityUpdateActionField.TagId).flatMap(f=>SecurityUpdateActionField.decode(f)),
        myFields.get(CorporateActionField.TagId).flatMap(f=>CorporateActionField.decode(f)),
        myFields.get(MarketIDField.TagId).flatMap(f=>MarketIDField.decode(f)),
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        SecLstUpdRelSymGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     