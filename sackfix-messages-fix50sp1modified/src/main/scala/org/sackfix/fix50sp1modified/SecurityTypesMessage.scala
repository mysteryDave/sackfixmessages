package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class SecurityTypesMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                securityReqIDField:SecurityReqIDField,
                                securityResponseIDField:SecurityResponseIDField,
                                securityResponseTypeField:SecurityResponseTypeField,
                                totNoSecurityTypesField:Option[TotNoSecurityTypesField]=None,
                                lastFragmentField:Option[LastFragmentField]=None,
                                secTypesGrpComponent:Option[SecTypesGrpComponent]=None,
                                textField:Option[TextField]=None,
                                encodedTextLenField:Option[EncodedTextLenField]=None,
                                encodedTextField:Option[EncodedTextField]=None,
                                marketIDField:Option[MarketIDField]=None,
                                marketSegmentIDField:Option[MarketSegmentIDField]=None,
                                tradingSessionIDField:Option[TradingSessionIDField]=None,
                                tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None) extends SfFixMessageBody("w")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    fmt(b,securityReqIDField)
    fmt(b,securityResponseIDField)
    fmt(b,securityResponseTypeField)
    totNoSecurityTypesField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    secTypesGrpComponent.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    marketIDField.foreach(fmt(b,_))
    marketSegmentIDField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    b
  }

}
     
object SecurityTypesMessage extends SfFixMessageDecoder {
  val MsgType="w"
  val MsgName="SecurityTypes"
             
  override val MandatoryFields = HashSet[Int](
    SecurityReqIDField.TagId, SecurityResponseIDField.TagId, SecurityResponseTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || SecTypesGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TotNoSecurityTypesField.TagId, LastFragmentField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, 
    MarketIDField.TagId, MarketSegmentIDField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SubscriptionRequestTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || SecTypesGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || SecTypesGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityTypesMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        SecurityReqIDField.decode(myFields.get(SecurityReqIDField.TagId)).get,
        SecurityResponseIDField.decode(myFields.get(SecurityResponseIDField.TagId)).get,
        SecurityResponseTypeField.decode(myFields.get(SecurityResponseTypeField.TagId)).get,
        myFields.get(TotNoSecurityTypesField.TagId).flatMap(f=>TotNoSecurityTypesField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        SecTypesGrpComponent.decode(flds, startPos),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(MarketIDField.TagId).flatMap(f=>MarketIDField.decode(f)),
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f))))
    } else None
  }

    
}
     