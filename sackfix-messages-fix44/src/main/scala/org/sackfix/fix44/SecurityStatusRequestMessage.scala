package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class SecurityStatusRequestMessage(securityStatusReqIDField:SecurityStatusReqIDField,
                                        instrumentComponent:InstrumentComponent,
                                        instrumentExtensionComponent:Option[InstrumentExtensionComponent]=None,
                                        noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                        underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                        noLegsField:Option[NoLegsField]=None,
                                        legsGroups: Option[List[LegsGroup]]=None,
                                        currencyField:Option[CurrencyField]=None,
                                        subscriptionRequestTypeField:SubscriptionRequestTypeField,
                                        tradingSessionIDField:Option[TradingSessionIDField]=None,
                                        tradingSessionSubIDField:Option[TradingSessionSubIDField]=None) extends SfFixMessageBody("e")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,securityStatusReqIDField)
    fmt(b,instrumentComponent)
    instrumentExtensionComponent.foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    fmt(b,subscriptionRequestTypeField)
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    b
  }

}
     
object SecurityStatusRequestMessage extends SfFixMessageDecoder {
  val MsgType="e"
  val MsgName="SecurityStatusRequest"
             
  override val MandatoryFields = HashSet[Int](
    SecurityStatusReqIDField.TagId, SubscriptionRequestTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || InstrumentExtensionComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoUnderlyingsField.TagId, NoLegsField.TagId, CurrencyField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || InstrumentExtensionComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || InstrumentExtensionComponent.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || 
    LegsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingsField.TagId, NoLegsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecurityStatusReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityStatusRequestMessage(SecurityStatusReqIDField.decode(myFields.get(SecurityStatusReqIDField.TagId)).get,
        InstrumentComponent.decode(flds, startPos).get,
        InstrumentExtensionComponent.decode(flds, startPos),
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        SubscriptionRequestTypeField.decode(myFields.get(SubscriptionRequestTypeField.TagId)).get,
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f))))
    } else None
  }

    
}
     