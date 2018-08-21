package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class SecurityTypesMessage(securityReqIDField:SecurityReqIDField,
                                securityResponseIDField:SecurityResponseIDField,
                                securityResponseTypeField:SecurityResponseTypeField,
                                totNoSecurityTypesField:Option[TotNoSecurityTypesField]=None,
                                lastFragmentField:Option[LastFragmentField]=None,
                                noSecurityTypesField:Option[NoSecurityTypesField]=None,
                                securityTypesGroups: Option[List[SecurityTypesGroup]]=None,
                                textField:Option[TextField]=None,
                                encodedTextLenField:Option[EncodedTextLenField]=None,
                                encodedTextField:Option[EncodedTextField]=None,
                                tradingSessionIDField:Option[TradingSessionIDField]=None,
                                tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None) extends SfFixMessageBody("w")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSecurityTypesField.map(_.value).getOrElse(0) != securityTypesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSecurityTypesField.TagId,noSecurityTypesField.map(_.value).getOrElse(0), securityTypesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,securityReqIDField)
    fmt(b,securityResponseIDField)
    fmt(b,securityResponseTypeField)
    totNoSecurityTypesField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    noSecurityTypesField.foreach(fmt(b,_))
    securityTypesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
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
    SecurityTypesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TotNoSecurityTypesField.TagId, LastFragmentField.TagId, NoSecurityTypesField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SubscriptionRequestTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SecurityTypesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SecurityTypesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSecurityTypesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecurityReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityTypesMessage(SecurityReqIDField.decode(myFields.get(SecurityReqIDField.TagId)).get,
        SecurityResponseIDField.decode(myFields.get(SecurityResponseIDField.TagId)).get,
        SecurityResponseTypeField.decode(myFields.get(SecurityResponseTypeField.TagId)).get,
        myFields.get(TotNoSecurityTypesField.TagId).flatMap(f=>TotNoSecurityTypesField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        myFields.get(NoSecurityTypesField.TagId).flatMap(f=>NoSecurityTypesField.decode(f)),
        if (nextTagPosLookup.contains(NoSecurityTypesField.TagId)) SecurityTypesGroup.decode(flds, nextTagPosLookup(NoSecurityTypesField.TagId)) else None,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f))))
    } else None
  }

    
}
     