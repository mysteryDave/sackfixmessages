package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class MassQuoteAcknowledgementMessage(quoteReqIDField:Option[QuoteReqIDField]=None,
                                           quoteIDField:Option[QuoteIDField]=None,
                                           quoteStatusField:QuoteStatusField,
                                           quoteRejectReasonField:Option[QuoteRejectReasonField]=None,
                                           quoteResponseLevelField:Option[QuoteResponseLevelField]=None,
                                           quoteTypeField:Option[QuoteTypeField]=None,
                                           partiesComponent:Option[PartiesComponent]=None,
                                           accountField:Option[AccountField]=None,
                                           accountTypeField:Option[AccountTypeField]=None,
                                           textField:Option[TextField]=None,
                                           noQuoteSetsField:Option[NoQuoteSetsField]=None,
                                           quoteSetsGroups: Option[List[QuoteSetsGroup]]=None) extends SfFixMessageBody("b")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteSetsField.map(_.value).getOrElse(0) != quoteSetsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoQuoteSetsField.TagId,noQuoteSetsField.map(_.value).getOrElse(0), quoteSetsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteReqIDField.foreach(fmt(b,_))
    quoteIDField.foreach(fmt(b,_))
    fmt(b,quoteStatusField)
    quoteRejectReasonField.foreach(fmt(b,_))
    quoteResponseLevelField.foreach(fmt(b,_))
    quoteTypeField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    noQuoteSetsField.foreach(fmt(b,_))
    quoteSetsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object MassQuoteAcknowledgementMessage extends SfFixMessageDecoder {
  val MsgType="b"
  val MsgName="MassQuoteAcknowledgement"
             
  override val MandatoryFields = HashSet[Int](
    QuoteStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || QuoteSetsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteReqIDField.TagId, QuoteIDField.TagId, QuoteRejectReasonField.TagId, QuoteResponseLevelField.TagId, QuoteTypeField.TagId, 
    AccountField.TagId, AccountTypeField.TagId, TextField.TagId, NoQuoteSetsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || QuoteSetsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || QuoteSetsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteSetsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MassQuoteAcknowledgementMessage(myFields.get(QuoteReqIDField.TagId).flatMap(f=>QuoteReqIDField.decode(f)),
        myFields.get(QuoteIDField.TagId).flatMap(f=>QuoteIDField.decode(f)),
        QuoteStatusField.decode(myFields.get(QuoteStatusField.TagId)).get,
        myFields.get(QuoteRejectReasonField.TagId).flatMap(f=>QuoteRejectReasonField.decode(f)),
        myFields.get(QuoteResponseLevelField.TagId).flatMap(f=>QuoteResponseLevelField.decode(f)),
        myFields.get(QuoteTypeField.TagId).flatMap(f=>QuoteTypeField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(NoQuoteSetsField.TagId).flatMap(f=>NoQuoteSetsField.decode(f)),
        if (nextTagPosLookup.contains(NoQuoteSetsField.TagId)) QuoteSetsGroup.decode(flds, nextTagPosLookup(NoQuoteSetsField.TagId)) else None))
    } else None
  }

    
}
     